package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {
    private List<String> todosPOX = new ArrayList<>();
    
    // RMM: Level 0 - Swamp of Pox
    @RequestMapping("/gettodos")
    public String getAllTodos() {
        return todosPOX.toString();
    }

    @RequestMapping("/getTodoById")
    public String getTodoById(int id) {
        return "Details of todo with ID: " + id;
    }

    public String createTodo(String todo) {
        return "Created todo: " + todo;
    }

    // RMM - Level 1 - Resources
    // RMM - Level 2 - HTTP Methods

    private List<TodoItem> todos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodos() {
        var tempTodo = new TodoItem("Sample", "This is a sample todo item.");
        todos.add(tempTodo);
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{title}")
    public ResponseEntity<TodoItem> getTodo(@PathVariable String title) {
        var item = todos.stream()
            .filter(t -> t.getTitle().equals(title))
            .findFirst()
            .orElse(null);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem newTodo) {
        todos.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @PutMapping("/{title}")
    public ResponseEntity<TodoItem> updateTodo(@PathVariable String title, @RequestBody String description) {
        var updatedTodo = todos.stream()
            .filter(t -> t.getTitle().equals(title))
            .findFirst()
            .orElse(null);  

        if (updatedTodo != null) {
            updatedTodo.setDescription(description);  
            return ResponseEntity.ok(updatedTodo);  
        } else {
            return ResponseEntity.notFound().build();  
        }
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String title) {
        todos.removeIf(t -> t.getTitle().equals(title));
        return ResponseEntity.noContent().build();  
    }

}
