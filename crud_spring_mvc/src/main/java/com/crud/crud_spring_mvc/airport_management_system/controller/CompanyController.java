package com.crud.crud_spring_mvc.airport_management_system.controller;

import com.crud.crud_spring_mvc.airport_management_system.model.Company;
import com.crud.crud_spring_mvc.airport_management_system.dao_impl.CompanyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Nov-20
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyImpl companyService;

    @PostMapping("add")
    public Company add(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping(path = "/company/{id}")
    public Company getById(@PathVariable int id) {
        return companyService.getById(id);
    }

    @GetMapping(path = "/companies")
    public Set<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping(path = "/{page}/{perPage}/{sort}")
    public Set<Company> get(@PathVariable int page, @PathVariable int perPage, @PathVariable String sort) {
        return companyService.get(page, perPage, sort);
    }

    @PutMapping(path = "/update")
    public Company update(@RequestBody Company company) {
        return companyService.update(company);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id) {
        companyService.delete(id);
    }
}
