package com.example.todo.service;

import com.example.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    Todo getTodoById(String id);

    void createTodo(Todo todo);

    void updateTodo(String id, Todo todo);

    void deleteTodo(String id);

    List<Todo> getAllActiveTodos();



}
