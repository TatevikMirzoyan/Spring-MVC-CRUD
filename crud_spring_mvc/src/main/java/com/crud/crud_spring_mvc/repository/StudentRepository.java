package com.crud.crud_spring_mvc.repository;

import com.crud.crud_spring_mvc.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tatevik Mirzoyan
 * Created on 13-Nov-20
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
