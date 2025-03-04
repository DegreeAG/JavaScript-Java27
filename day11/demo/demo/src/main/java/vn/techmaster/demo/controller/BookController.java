package vn.techmaster.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.service.BookService;

import java.util.List;


@RestController
@RequestMapping("/books")

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //1.lấy danh sách book: GET-/books
    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    //2.Lấy chi tiết cuốn sách theo id: GET - /books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id){
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
    @GetMapping("/sortByYear")
    public ResponseEntity<List<Book>> sortByYear(){
        List<Book> books = bookService.sortByYear();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Book>> getBookByKeyWord(@PathVariable String keyword){
        List<Book> books = bookService.getBookByKeyword(keyword);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/startYear/{startYear}/endYear/{endYear}")
    public ResponseEntity<List<Book>> getBookByYear(@PathVariable int startYear, @PathVariable int endYear){
        List<Book> books = bookService.getBookByYear(startYear,endYear);
        return ResponseEntity.ok(books);
    }
}
