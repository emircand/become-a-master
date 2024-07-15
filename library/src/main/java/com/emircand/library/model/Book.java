package com.emircand.library.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String genre;
    private String language;
    private int pages;
    private String publisher;
    private String description;
    private boolean isAvailable;

    public Book() {
    }

    public Book(int id, String title, String author, LocalDate publicationDate, String genre, String language, int pages,
            String publisher, String description, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.language = language;
        this.pages = pages;
        this.publisher = publisher;
        this.description = description;
        this.isAvailable = isAvailable;
    }


}
