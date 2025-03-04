package vn.techmaster.demo.service;

import vn.techmaster.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(String id);

    List<Book> sortByYear();

    List<Book> getBookByKeyword(String keyword);

    List<Book> getBookByYear(int startYear, int endYear);
}
