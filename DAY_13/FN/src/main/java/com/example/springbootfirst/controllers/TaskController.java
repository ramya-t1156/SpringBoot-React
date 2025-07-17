package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Task;
import com.example.springbootfirst.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/{empId}")
    public List<Task> getTasksByEmployeeId(@PathVariable int empId) {
        return taskService.getTasksByEmpId(empId);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }
}
