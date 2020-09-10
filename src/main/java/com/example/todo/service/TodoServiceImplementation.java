package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImplementation implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {

        List<Todo> todos = new ArrayList<>();
        todos.addAll(todoRepository.findAll());
        return todos;

    }

    @Override
    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    @Override
    public void createTodo(Todo todo) {
        Todo _todo = todoRepository.save(new Todo(todo.getTitle(), todo.getDescription(), false));

    }

    @Override
    public void updateTodo(String id, Todo todo) {
        Optional<Todo> todoData = todoRepository.findById(id);
        if (todoData.isPresent()) {
            Todo _todo = todoData.get();
            _todo.setTitle(todo.getTitle());
            _todo.setDescription(todo.getDescription());
            _todo.setCompleted(todo.isCompleted());
            todoRepository.save(_todo);

        }

    }

    @Override
    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    @Override
    public List<Todo> getAllActiveTodos() {
        return todoRepository.findByCompleted(false);

    }
}
