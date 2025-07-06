package com.example.SpringApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String name;
    public String status;
    // should be one of: "Yet to Start" , "In Progress" , "Completed"
}
