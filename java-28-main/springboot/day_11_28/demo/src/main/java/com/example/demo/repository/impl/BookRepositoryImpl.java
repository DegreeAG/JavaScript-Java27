package com.example.demo.repository.impl;

import com.example.demo.db.BookDB;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll() { // select * from books
        return BookDB.books;
    }

    @Override
    public Book findById(String id) { // select * from books where id = ?
        for (Book book : BookDB.books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
