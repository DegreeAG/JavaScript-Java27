package vn.techmaster.demo.service.impl;

import org.springframework.stereotype.Service;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.repository.BookRepository;
import vn.techmaster.demo.service.BookService;

import java.util.Comparator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        //C1: findAll -> for loop -> if -> return
//        List<Book> books = bookRepository.findAll();
//        for (Book book: books){
//            if(book.getId().equals(id)){
//                return book;
//            }
//        }
//        return null;


        //C2: Lấy trực tiếp trong db
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> sortByYear() {
        //C1: findAll--> sort -->return
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
    public List<Book> getBookByKeyword(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Book> getBookByYear(int startYear, int endYear) {
        return bookRepository.findByYearBetween(startYear, endYear);
    }
}
