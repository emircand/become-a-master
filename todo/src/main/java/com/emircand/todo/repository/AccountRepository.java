package com.emircand.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emircand.todo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
    Account findByEmail(String email);
    
}
