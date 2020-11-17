package com.crud.crud_spring_mvc.airportManagementSystem.service;


import com.crud.crud_spring_mvc.airportManagementSystem.repository.CompanyDAO;
import com.crud.crud_spring_mvc.airportManagementSystem.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 25-Sep-20
 */
@Service
public class CompanyImpl {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Autowired
    private CompanyDAO companyDAO;

    public Company getById(int id) {
        Company company = entityManager.find(Company.class, id);
        entityManager.close();
        return company;
    }

    @SuppressWarnings("unchecked")
    public Set<Company> getAll() {
        Set<Company> companies = new LinkedHashSet<>();
        try {
            Query query = entityManager.createQuery("SELECT c FROM Company c ");
            List<Company> list = (List<Company>) query.getResultList();
            companies.addAll(list);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        entityManager.close();
        return companies;
    }

    @SuppressWarnings("unchecked")
    public Set<Company> get(int page, int perPage, String sort) {
        Set<Company> companies = new LinkedHashSet<>();
        String query = "SELECT c FROM Company c order by c." + sort;
        try {
            List<Company> list = (List<Company>) entityManager
                    .createQuery(query)
                    .setMaxResults(perPage)
                    .setFirstResult(((page - 1) * perPage))
                    .getResultList();
            companies.addAll(list);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        entityManager.close();
        return companies;
    }

    public Company save(Company company) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(company);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return company;
    }

    public Company update(Company company) {
        entityManager.getTransaction().begin();
        try {
            Company updatedCompany = entityManager.find(Company.class, company.getId());
            updatedCompany.setName(company.getName());
            updatedCompany.setFound_date(company.getFound_date());
            entityManager.persist(updatedCompany);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return company;
    }

    public void delete(int companyId) {
        entityManager.getTransaction().begin();
        try {
            Company company = entityManager.find(Company.class, companyId);
            entityManager.remove(company);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }
}
