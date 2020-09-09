package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoServiceImplementation implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return null;
    }

    @Override
    public Todo getTodoById(String id) {
        return null;
    }

    @Override
    public void createTodo(Todo todo) {

    }

    @Override
    public void updateTodo(String id, Todo todo) {

    }

    @Override
    public void deleteTodo(String id) {

    }

    @Override
    public List<Todo> getAllActiveTodos() {
        return null;
    }
}
