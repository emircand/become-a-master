package com.emircand.library.repository;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emircand.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    ArrayList<Book> findAll();
    Book findById(int id);
    @SuppressWarnings("unchecked")
    Book save(Book book);
    void deleteById(int id);
    
}
