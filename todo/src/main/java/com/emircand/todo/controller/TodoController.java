package com.emircand.todo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.emircand.todo.service.TodoService;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getTodos(@RequestParam int id) {
        return ResponseEntity.ok(todoService.getTodos(id));
    }
    

}
