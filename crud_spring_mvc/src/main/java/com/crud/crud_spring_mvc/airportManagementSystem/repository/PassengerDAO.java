package com.crud.crud_spring_mvc.airportManagementSystem.repository;


import com.crud.crud_spring_mvc.airportManagementSystem.model.Passenger;
import com.crud.crud_spring_mvc.airportManagementSystem.model.Trip;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 20-Sep-20
 */
@Repository
public interface PassengerDAO {

    Passenger getById(int id);

    Set<Passenger> getAll();

    Set<Passenger> get(int page, int perPage, String sort);

    Passenger save(Passenger passenger);

    Passenger update(Passenger passenger);

    void delete(int passengerId);

    List<Passenger> getPassengersOfTrip(int tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(int passengerId, int tripNumber);

}
