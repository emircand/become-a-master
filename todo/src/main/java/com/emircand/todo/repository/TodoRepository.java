package com.emircand.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emircand.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByStatus(int status);

    List<Todo> findByTitle(String title);

    List<Todo> findByAccountId(int accountId);
	
}
