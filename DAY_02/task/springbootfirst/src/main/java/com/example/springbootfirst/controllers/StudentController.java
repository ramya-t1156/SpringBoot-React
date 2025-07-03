package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Student.Student;
import com.example.springbootfirst.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService s;

    @GetMapping("/")
    public List<Student> getMethod(){
        return s.getStudent();
    }

    @PostMapping("/")
    public String postMethod(){
        return s.postStudent();
    }

    @PutMapping("/")
    public String putMethod(){
        return s.putStudent();
    }

    @DeleteMapping("/")
    public String deleteMethod(){
        return s.deleteStudent();
    }
}
