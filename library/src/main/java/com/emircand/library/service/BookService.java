package com.emircand.library.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.emircand.library.model.Book;
import com.emircand.library.repository.BookRepository;

@Service
public class BookService {
    
    private BookRepository bookRepository;

    public ArrayList<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
