package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        try {
            List<Todo> todos = new ArrayList<>();
            todos.addAll(todoService.getAllTodos());

            if (todos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(todos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") String id) {
        Optional<Todo> todoData = todoService.getTodoById(id);
        return todoData.map(todo -> new ResponseEntity<>(todo, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        try {
            // Todo _todo = todoRepository.save(new Todo(todo.getTitle(), todo.getDescription(), false));
            todoService.createTodo(todo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id, @RequestBody Todo todo) {
//        Optional<Todo> todoData = todoRepository.findById(id);
//        if (todoData.isPresent()) {
//            Todo _todo = todoData.get();
//            _todo.setTitle(todo.getTitle());
//            _todo.setDescription(todo.getDescription());
//            _todo.setCompleted(todo.isCompleted());
//
//            return new ResponseEntity<>(todoRepository.save(_todo), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        todoService.updateTodo(id, todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") String id) {
        try {
            todoService.deleteTodo(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/todos")
    public ResponseEntity<HttpStatus> deleteAllTodo() {
        try {
            todoService.deleteAllTodos();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todos/active")
    public ResponseEntity<List<Todo>> findActiveTodos() {
        try {
            List<Todo> activeTodosList = todoService.getAllActiveTodos();

            if (activeTodosList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(activeTodosList, HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
