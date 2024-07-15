package com.emircand.todo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodoDTO {
    private int id;
    private String title;
    private String description;
    private int status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int accountId;

    public TodoDTO() {
    }

    public TodoDTO(int id, String title, String description, int status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
