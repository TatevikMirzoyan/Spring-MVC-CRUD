package com.crud.crud_spring_mvc.student_authorisation_program.repository;

import com.crud.crud_spring_mvc.student_authorisation_program.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tatevik Mirzoyan
 * Created on 13-Nov-20
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
