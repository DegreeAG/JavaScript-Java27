package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping // HTTP method + API URL
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 2. Lấy chi tiết book theo id: GET - /books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    /*
    1. Viết API để trả về danh sachs book. Sắp xếp theo năm giảm dần
    GET: /books/sortByYear

    2. Viết API để tìm kiếm các cuốn sách mà trong title có chứa keyword, không phân biệt hoa thường
    GET: /books/search/{keyword}

    3. Viết API để tìm kiếm các cuốn sách có year được sản xuất từ năm A -> năm B
    GET: /books/startYear/{startYear}/endYear/{endYear}
    */
//    @GetMapping("/sortByYear")
//    public ResponseEntity<List<Book>> sortByYear() {
//        books.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getYear() - o1.getYear();
//            }
//        });
//
//        return ResponseEntity.ok(books);
//    }
//
//    @GetMapping("/search/{keyword}")
//    public ResponseEntity<List<Book>> getBooksByKeyword(@PathVariable String keyword) {
//        List<Book> rs = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
//                rs.add(book);
//            }
//        }
//        return ResponseEntity.ok(rs);
//    }
//
//    @GetMapping("/startYear/{startYear}/endYear/{endYear}")
//    public ResponseEntity<List<Book>> getBooksByYear(@PathVariable int startYear, @PathVariable int endYear) {
//        List<Book> rs = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getYear() >= startYear && book.getYear() <= endYear) {
//                rs.add(book);
//            }
//        }
//        return ResponseEntity.ok(rs);
//    }
}
