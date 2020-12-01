package com.crud.crud_spring_mvc.student_authorisation_program.controller;

import com.crud.crud_spring_mvc.student_authorisation_program.service.StudentService;
import com.crud.crud_spring_mvc.student_authorisation_program.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tatevik Mirzoyan
 * Created on 13-Nov-20
 */
@Controller
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getStart(Model model) {
        String message = "Student authorisation";
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(path = "/get/{id}")
    public String getStudentById(Model model, @PathVariable int id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        if (student == null) {
            return "redirect:/students/list";
        }
        return "studentInfo";
    }

    @GetMapping(path = "/list")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping(path = "addStudent")
    public String addingStudent(Model model, Student student) {
        model.addAttribute("student", student);
        return "addStudent";
    }

    @PostMapping(path = "/add")
    public String addStudent(Student student, Model model) {
        studentService.addStudent(student);
        model.addAttribute("student", student);

        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        Integer age = student.getAge();

        if (firstName != null && firstName.length() > 0
                && lastName != null && lastName.length() > 0) {
            return "redirect:/students/list";
        }
        String errorMessage = "First Name and Last Name are required";
        model.addAttribute("errorMessage", errorMessage);
        return "addStudent";
    }

    //TODO did not working
    @GetMapping(path = "deleteStudent")
    public String deletingStudent(Model model) {
        return "deleteStudent";
    }

    //TODO
    @DeleteMapping(path = "/delete/{id}")
    public String deleteStudentById(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }

}
