package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody

//Marks the class as a controller (like @Controller)
//Automatically serializes return values into JSON (or XML) and sends it as the HTTP response body (like @ResponseBody)
@RestController
//When a request comes to this URL, run this method
//(now the url should like "http://localhost:8080/employee" ) but without this ("http://localhost:8080")
@RequestMapping("/employee")
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;

    @GetMapping
    public List<Employee> getEmployees(){
        return hws.getEmployees();
    }

//    @PathVariable - getting the data from the path/url
//    get by employee Id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return hws.getEmployeeById(id);
    }

//    @PostMapping("/")
//    public String postMethod(){
//        Employee emp = new Employee(3,"rosy","Business");
//        return hws.postMethodService(emp);
//    }

//    @RequestBody binds HTTP request body content to a Java object.
//    post - adding data
    @PostMapping
    public String addEmployee(@RequestBody Employee emp){
        return hws.addEmployee(emp);
    }

//    put - update data
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return hws.updateEmployee(id,emp);
    }

//    delete - delete data
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return hws.deleteEmployeeById(id);
    }
}