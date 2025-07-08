package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Student;
import com.example.springbootfirst.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

    public Student getStudentById(int id){
        return studentRepo.findById(id).orElse(new Student());
    }

    public List<Student> getStudentsByDept(String dept){
        return studentRepo.findByDept(dept);
    }

    public String addStudent(Student s){
        studentRepo.save(s);
        return "Student added successfully";
    }

    public String updateStudent(int id ,  Student s){
        studentRepo.save(s);
        return "Student updated successfully";
    }

    public String deleteAllStudents(){
        studentRepo.deleteAll();
        return "All students deleted successfully";
    }

    public String deleteStudentById(int id){
        studentRepo.deleteById(id);
        return "Student deleted successfully";
    }
}
