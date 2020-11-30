package com.crud.crud_spring_mvc.airport_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Sep-20
 */

@Data
@NoArgsConstructor
@Entity
//@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @Column(columnDefinition = "DATE")
    LocalDate found_date;

    public Company(String name, LocalDate found_date) {
        this.name = name;
        this.found_date = found_date;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", found_date=" + found_date +
                '}';
    }
}
