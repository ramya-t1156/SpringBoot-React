package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<RegisterDetails> getEmployees(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public RegisterDetails getEmployeeById(@PathVariable int id){
        return  employeeService.getEmployeeById(id);
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String addEmployee(@RequestBody UserDetailsDto dto){
        return employeeService.addEmployee(dto);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String updateEmployee(@PathVariable int id, @RequestBody UserDetailsDto reg){
        return employeeService.updateEmployeeById(id, reg);
    }


    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployees(){
        return employeeService.deleteAllEmployees();
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }


    @GetMapping("/roles/{role}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RegisterDetails> getEmployeesByRoles(@PathVariable String role){
        return employeeService.findEmployeesByRole(role);
    }


    @GetMapping("/search")
    public ResponseEntity<List<RegisterDetails>> searchByUserName(@RequestParam String userName) {
        List<RegisterDetails> results = employeeService.searchByUserName(userName);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}
