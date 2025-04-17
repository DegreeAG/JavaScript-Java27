package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(String id);

    List<Book> sortByYear();

    List<Book> getBooksByKeyword(String keyword);

    List<Book> getBooksByYear(int startYear, int endYear);
}
