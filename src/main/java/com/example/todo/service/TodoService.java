package com.example.todo.service;

import com.example.todo.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getAllTodos();

    Optional<Todo> getTodoById(String id);

    void createTodo(Todo todo);

    void updateTodo(String id, Todo todo);

    void deleteTodo(String id);

    void deleteAllTodos();

    List<Todo> getAllActiveTodos();



}
