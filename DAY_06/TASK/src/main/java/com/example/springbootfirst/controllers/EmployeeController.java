package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody

//Marks the class as a controller (like @Controller)
//Automatically serializes return values into JSON (or XML) and sends it as the HTTP response body (like @ResponseBody)
@RestController
////When a request comes to this URL, run this method
////(now the url should like "http://localhost:8080/employee" ) but without this ("http://localhost:8080")
//@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService hws;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getEmployees(){
        return hws.getEmployees();
    }


//    @PathVariable - getting the data from the path/url
//    get by employee Id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Employee getEmployeeById(@PathVariable int id){
        return hws.getEmployeeById(id);
    }


    @GetMapping("/job/{job}")
    @PreAuthorize("hasRole(ADMIN')")
    public List<Employee> getEmployeesByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }


    @GetMapping("/name/{name}")
    @PreAuthorize("hasRole(ADMIN')")
    public List<Employee> getEmployeesByName(@PathVariable String name){
        return hws.getEmployeeByName(name);
    }


//    @RequestBody binds HTTP request body content to a Java object.
//    post - adding data
    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String addEmployee(@RequestBody Employee emp){
        return hws.addEmployee(emp);
    }


//    put - update data
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return hws.updateEmployee(id,emp);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployees(){
        return hws.deleteEmployees();
    }

//    delete - delete data
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployeeById(@PathVariable int id){
        return hws.deleteEmployeeById(id);
    }
}