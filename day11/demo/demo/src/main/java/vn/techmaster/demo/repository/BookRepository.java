package vn.techmaster.demo.repository;

import vn.techmaster.demo.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findById(String id);

    List<Book> findByTitleContainingIgnoreCase(String keyword);

    List<Book> findByYearBetween(int startYear, int endYear);
}
