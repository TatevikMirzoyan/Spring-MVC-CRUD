package com.crud.crud_spring_mvc.student_authorisation_program.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * @author Tatevik Mirzoyan
 * Created on 13-Nov-20
 */
@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "FirstName cannot be empty")
    private String firstName;
    @NotBlank(message = "LastName cannot be empty")
    private String lastName;
    @NotNull(message = "Age cannot be null")
    @Min(value = 16, message = "Age must be greater than 16")
    @Max(value = 40, message = "Age must be less than 40")
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
