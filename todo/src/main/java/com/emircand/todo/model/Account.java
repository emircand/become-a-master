package com.emircand.todo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "account")
    private List<Todo> todos;

    public Account() {
        this.todos = new ArrayList<>();
    }

    public Account(String username, String password, String email) {
        this();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account(int id, String username, String password, String email) {
        this();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
