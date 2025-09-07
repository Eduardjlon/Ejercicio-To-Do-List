package com.jonh.uspgtodolist.Model;

public class TaskModel {

    private String description;
    private boolean completed;

    // Constructor
    public TaskModel(String description) {
        this.description = description;
        this.completed = false;
    }

    // Getters y Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
