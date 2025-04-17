package com.example.demo.repository.impl;

import com.example.demo.db.BookDB;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Override
    public List<Book> findByTitleContainingIgnoreCase(String keyword) { // select * from books where title like %?%
        List<Book> rs = new ArrayList<>();
        for (Book book : BookDB.books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                rs.add(book);
            }
        }
        return rs;
    }

    @Override
    public List<Book> findByYearBetween(int startYear, int endYear) {
        List<Book> rs = new ArrayList<>();
        for (Book book : BookDB.books) {
            if (book.getYear() >= startYear && book.getYear() <= endYear) {
                rs.add(book);
            }
        }
        return rs;
    }
}
