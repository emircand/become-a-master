package com.emircand.todo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emircand.todo.dto.TodoDTO;
import com.emircand.todo.model.Account;
import com.emircand.todo.model.Todo;
import com.emircand.todo.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private AccountService accountService;

    public TodoService(TodoRepository todoRepository, AccountService accountService) {
        this.todoRepository = todoRepository;
        this.accountService = accountService;
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }
    
    public void updateItem(TodoDTO todoDTO) {
        todoRepository.findById(todoDTO.getId()).ifPresent(todo -> {
            todo.setTitle(todoDTO.getTitle());
            todo.setDescription(todoDTO.getDescription());
            todo.setStatus(todoDTO.getStatus());
            todo.setUpdatedAt(LocalDateTime.now());
            todoRepository.save(todo);
        });
    }

    public Account findAccount(int accountId) {
        return accountService.getAccountByID(accountId);
    }

    public void addItem(TodoDTO todoDTO) {
        todoRepository.save(new Todo(todoDTO.getId(),
            todoDTO.getTitle(),
            todoDTO.getDescription(),
            todoDTO.getStatus(),
            todoDTO.getCreatedAt(),
            todoDTO.getUpdatedAt(),
            findAccount(todoDTO.getAccountId())));
    }

    public TodoDTO getItem(int id) {
        Todo todo = todoRepository.findById(id).get();
        return new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus().ordinal(), todo.getCreatedAt(), todo.getUpdatedAt());
    }

    public List<TodoDTO> getAllItems() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoDTO> todoDTOs = new ArrayList<>();
        for (Todo todo : todos) {
            todoDTOs.add(new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus().ordinal(), todo.getCreatedAt(), todo.getUpdatedAt()));
        }
        return todoDTOs;
    }

    public List<TodoDTO> getItemsByStatus(int status) {
        List<Todo> todos = todoRepository.findByStatus(status);
        List<TodoDTO> todoDTOs = new ArrayList<>();
        for (Todo todo : todos) {
            todoDTOs.add(new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus().ordinal(), todo.getCreatedAt(), todo.getUpdatedAt()));
        }
        return todoDTOs;
    }

    public List<TodoDTO> getItemsByTitle(String title) {
        List<Todo> todos = todoRepository.findByTitle(title);
        List<TodoDTO> todoDTOs = new ArrayList<>();
        for (Todo todo : todos) {
            todoDTOs.add(new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus().ordinal(), todo.getCreatedAt(), todo.getUpdatedAt()));
        }
        return todoDTOs;
    }

    public List<TodoDTO> getTodos(int account_id){
        List<Todo> todos = todoRepository.findByAccountId(account_id);
        List<TodoDTO> todoDTOs = new ArrayList<>();
        for (Todo todo : todos) {
            todoDTOs.add(new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus().ordinal(), todo.getCreatedAt(), todo.getUpdatedAt()));
        }
        return todoDTOs;
    }
    
}
