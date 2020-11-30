package com.crud.crud_spring_mvc.airport_management_system.dao_impl;



import com.crud.crud_spring_mvc.airport_management_system.dao.PassengerDAO;
import com.crud.crud_spring_mvc.airport_management_system.model.Passenger;
import com.crud.crud_spring_mvc.airport_management_system.model.Trip;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tatevik Mirzoyan
 * Created on 25-Sep-20
 */
@Service
public class PassengerImpl implements PassengerDAO {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Passenger getById(int id) {
        Passenger passenger = entityManager.find(Passenger.class, id);
        entityManager.close();
        return passenger;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Passenger> getAll() {
        return (Set<Passenger>) entityManager
                .createQuery("SELECT p FROM Passenger p ")
                .getResultStream()
                .collect(Collectors.toSet());
    }

    //TODO
    @SuppressWarnings("unchecked")
    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        String query = "SELECT p FROM Passenger p order by p." + sort;
        return (Set<Passenger>) entityManager
                .createQuery(query)
                .setFirstResult(((page - 1) * perPage))
                .setMaxResults(perPage)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Override
    public Passenger save(Passenger passenger) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(passenger);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        entityManager.getTransaction().begin();
        try {
            Passenger updatedPassenger = entityManager.find(Passenger.class, passenger.getId());
            updatedPassenger.setName(passenger.getName());
            updatedPassenger.setPhone(passenger.getPhone());
            updatedPassenger.setAddress(passenger.getAddress());
            entityManager.persist(updatedPassenger);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return passenger;
    }

    @Override
    public void delete(int passengerId) {
        entityManager.getTransaction().begin();
        try {
            Passenger passenger = entityManager.find(Passenger.class, passengerId);
            entityManager.remove(passenger);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    //TODO
    @Override
    public List<Passenger> getPassengersOfTrip(int tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(int passengerId, int tripNumber) {

    }
}
