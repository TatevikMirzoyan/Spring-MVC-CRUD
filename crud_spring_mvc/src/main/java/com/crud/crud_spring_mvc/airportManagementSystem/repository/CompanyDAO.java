package com.crud.crud_spring_mvc.airportManagementSystem.repository;


import com.crud.crud_spring_mvc.airportManagementSystem.model.Company;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 17-Sep-20
 */
@Repository
public interface CompanyDAO {
    Company getById(int id);

    Set<Company> getAll();

    Set<Company> get(int page, int perPage, String sort);

    Company save(Company company);

    Company update(Company company);

    void delete(int companyId);
}
