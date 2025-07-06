package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> employees = new ArrayList<>(
            Arrays.asList(new Employee(1,"abi","Trainer"), new Employee(2,"anu","Faculty"))
    );

    public List<Employee> getEmployees(){
        return employees;
    }

    public Employee getEmployeeById(int id){
        int idx = 0;
        boolean found = false;
        for(int i = 0;i<employees.size();i++){
//            employees.get(i) --> gets the employee object (from List<Employee> employees)
//            getId() --> get the employee's id
            if(id==employees.get(i).getId()){
                System.out.println("Emp_id: " +  employees.get(i).getId() + " found");
                idx = i;
                found = true;
            }
        }
        if(!found){
            System.out.println("Employee with id " + id + " not found");
            return new Employee();
        }
        return employees.get(idx);
    }

//    public String postMethodService(Employee emp){
//        employees.add(emp);
//        return "Employee added Successfully";
//    }

    public String addEmployee(Employee emp){
        employees.add(emp);
        return "Employee added Successfully";
    }

    public String updateEmployee(int id,Employee emp){
        int idx = 0;
        boolean found = false;
        for(int i = 0;i<employees.size();i++){
            if(id==employees.get(i).getId()){
                idx = i;
                found = true;
            }
        }
        if(!found){
            return "Employee not found";
        }
        employees.set(idx, emp);
        return "Employee updated successfully";
    }

    public String deleteEmployeeById(int id) {
        Boolean flag = false;
        int idx = 0;
        for(int i = 0;i<employees.size();i++){
            if(id==employees.get(i).getId()){
                idx = i;
                flag = true;
                break;
            }
        }
        if(!flag){
            return  "Employee with id " + id + " not found";
        }
        return "Employee details deleted Successfully";
    }
}
