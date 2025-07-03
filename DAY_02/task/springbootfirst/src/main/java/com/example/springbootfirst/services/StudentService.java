package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Student.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(new Student(1,"rosy","ai&ds"), new Student(2,"rakki","cse"))
    );

    public List<Student> getStudent(){
        return students;
    }

    public String postStudent(){
        return "From post Student";
    }

    public String putStudent(){
        return "From put Student";
    }

    public String deleteStudent(){
        return "From delete Student";
    }
}
