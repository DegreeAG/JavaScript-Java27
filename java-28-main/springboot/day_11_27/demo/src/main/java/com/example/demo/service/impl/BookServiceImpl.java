package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        // C1: findAll -> for loop -> if -> return
//        List<Book> books = bookRepository.findAll();
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                return book;
//            }
//        }
//        return null;

        // C2: Lay truc tiep trong db
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> sortByYear() {
        // C1: findAll -> sort -> return
        List<Book> books = bookRepository.findAll();
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getYear() - o1.getYear();
            }
        });
        return books;
    }

    @Override
    public List<Book> getBooksByKeyword(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Book> getBooksByYear(int startYear, int endYear) {
        return bookRepository.findByYearBetween(startYear, endYear);
    }
}
