package com.example.todo.model;

public class Todo {

    private String id;

    private String title;
    private String description;
    private boolean completed;


    public Todo(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + completed + "]";
    }
}
