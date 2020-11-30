package com.crud.crud_spring_mvc.student_authorisation_program.service;

import com.crud.crud_spring_mvc.student_authorisation_program.model.Student;
import com.crud.crud_spring_mvc.student_authorisation_program.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Nov-20
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    public void addStudent(Student student) {
        if (student != null)
            studentRepository.save(student);
    }

    public void deleteStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Iterable<Student> iterable = studentRepository.findAll();
        for (Student student : iterable) {
            students.add(student);
        }
        return students;
    }
}
