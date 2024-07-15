package com.emircand.todo.service;

import org.springframework.stereotype.Service;

import com.emircand.todo.model.Account;
import com.emircand.todo.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String username, String email, String password) {
        accountRepository.save(new Account(username, email, password));
    }

    public Account getAccountByID(int id) {
        return accountRepository.findById(id).orElse(null);
    }
}
