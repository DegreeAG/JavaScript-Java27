package vn.techmaster.demo.repository.impl;

import org.springframework.stereotype.Repository;
import vn.techmaster.demo.db.BookDB;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

import static vn.techmaster.demo.db.BookDB.books;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll(){ //select+from books
        return BookDB.books;
    }

    @Override
    public Book findById(String id) {// select * from books where id?
        for (Book book: BookDB.books){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findByTitleContainingIgnoreCase(String keyword) {
        List<Book> rs = new ArrayList<>();
        for (Book book: BookDB.books){
            if(book.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                rs.add(book);
            }
        }
        return rs;
    }

    @Override
    public List<Book> findByYearBetween(int startYear, int endYear) {
        List<Book> rs = new ArrayList<>();
        for (Book book: BookDB.books) {
            if (book.getYear() >= startYear && book.getYear() <= endYear) {
                rs.add(book);
            }
        }
        return rs;
    }
}
