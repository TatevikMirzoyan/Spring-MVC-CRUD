package com.crud.crud_spring_mvc.student_authorisation_program.controller;

import com.crud.crud_spring_mvc.student_authorisation_program.service.StudentService;
import com.crud.crud_spring_mvc.student_authorisation_program.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String getAddStudentForm(Model model, Student student) {
        model.addAttribute("student", student);
        return "addStudent";
    }

    @PostMapping(path = "/add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "addStudent";
        }
        studentService.addStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteStudent(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }

    @GetMapping(path = "/edit/{id}")
    public String getUpdateStudentForm(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @PostMapping(path = "/update/{id}")
    public String updateStudent(@PathVariable int id, @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "update_student";
        }
        studentService.updateStudent(id, student);
        return "redirect:/students/list";

    }

}
