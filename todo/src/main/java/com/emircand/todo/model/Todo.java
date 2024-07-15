package com.emircand.todo.model;

import java.time.LocalDateTime;

import com.emircand.todo.model.enumaration.todoStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private todoStatus status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Todo() {
        
    }

    public Todo(String title, String description, todoStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Todo(int id, String title, String description, todoStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Todo(int id, String title, String description, int status, LocalDateTime createdAt, LocalDateTime updatedAt, Account account) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = todoStatus.values()[status];
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.account = account;
    }

    public void setStatus(int status) {
        this.status = todoStatus.values()[status];
    }

    public int getAccountId() {
        return getAccount().getId();
    }
}
