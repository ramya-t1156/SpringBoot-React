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

    public Student getStudentById(int id){
        int idx = 0;
        Boolean found = false;
        for(Student s: students){
            if(s.getId() == id){
                return s;
            }
        }
        return new Student();
    }

    public String addStudent(Student s){
        students.add(s);
        return "Student added successfully";
    }

    public String updateStudent(int id ,  Student s){
        int idx = 0;
        Boolean found = false;
        for(int i = 0;i<students.size();i++){
            if(students.get(i).getId() == id){
                found = true;
                idx = i;
                break;
            }
        }
        if(!found){
            return "Student not found";
        }
        students.set(idx,s);
        return "Student updated successfully";
    }

    public String deleteStudentById(int id){
        int idx = 0;
        for(int i = 0;i<students.size();i++){
            if(students.get(i).getId() == id){
                students.remove(i);
                return "Student deleted successfully";
            }
        }
        return "Student not found";
    }
}
