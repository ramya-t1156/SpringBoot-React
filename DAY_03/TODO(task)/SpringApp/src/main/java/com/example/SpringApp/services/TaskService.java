package com.example.SpringApp.services;

import com.example.SpringApp.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {
    List<Task> tasks = new ArrayList<>(
            Arrays.asList(new Task(1,"Read a Book","Yet to Start") , new Task(2,"Watch a match","In Progress"))
    );

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        int idx = 0;
        Boolean found = false;
        for(int i = 0; i < tasks.size(); i++) {
            if(id == tasks.get(i).getId()){
                idx = i;
                found = true;
                break;
            }
        }
        if(!found){
            return new Task();
        }
        return tasks.get(idx);
    }

    public List<Task> getTaskByStatus(String status) {
        List<Task> foundTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getStatus() != null && task.getStatus().trim().equalsIgnoreCase(status.trim())){
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    public String addTask(Task task){
        tasks.add(task);
        return "Task added successfully";
    }

    public String updateTask(int id , Task task){
        int idx = 0;
        Boolean found = false;
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == id){
                idx = i;
                found = true;
                break;
            }
        }
        if(!found){
            return "task not found";
        }
        tasks.set(idx,task);
        return "task updated successfully";
    }

    public String removeTask(int id){
        int idx = 0;
        Boolean found = false;
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == id){
                idx = i;
                found = true;
                break;
            }
        }
        if(!found){
            return "task not found";
        }
        tasks.remove(idx);
        return "task removed successfully";
    }
}
