package com.example.SpringApp.controllers;

import com.example.SpringApp.models.Task;
import com.example.SpringApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskService.getTask(id);
    }

    //GET : http://localhost:8080/task/status?status=In%20Progress , status=Completed , status=In%20Progress
    // here , " " (space) → %20
    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam String status){
        return taskService.getTaskByStatus(status);
    }

    @PostMapping
    public String addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("{id}")
    public String updateTask(@PathVariable int id , @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        return taskService.removeTask(id);
    }
}
