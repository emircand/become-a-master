package com.emircand.todo.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.emircand.todo.model.Todo;


public abstract class TodoRepositoryImpl implements TodoRepository {

    public List<Todo> findByStatus(int status) {
        return null;
    }

    public List<Todo> findByTitle(String title) {
        return null;
    }

    public List<Todo> findByAccountId(int accountId) {
        return findAll().stream()
                .filter(todo -> todo.getAccountId() == accountId)
                .collect(Collectors.toList());
    }
    
}
