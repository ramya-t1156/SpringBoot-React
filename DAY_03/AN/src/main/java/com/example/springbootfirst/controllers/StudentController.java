package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Student.Student;
import com.example.springbootfirst.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService s;

    @GetMapping
    public List<Student> getStudent(){
        return s.getStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return s.getStudentById(id);
    }

    @PostMapping
    public String addStudent(@RequestBody Student stu){
        return s.addStudent(stu);
    }

    @PutMapping("/{id}")
    public String updateStudentbyId(@PathVariable int id, @RequestBody Student stu){
        return s.updateStudent(id,stu);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable int id){
        return s.deleteStudentById(id);
    }
}
