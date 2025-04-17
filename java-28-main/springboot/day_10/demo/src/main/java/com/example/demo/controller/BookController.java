package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @Controller: Ap dung cho cac controller tra ve view (template). Ngoai ra cung co the tra ve JSON/XML giong @RestController (bo sung them thong)
 * @RestController = @Controller + @ResponseBody
 * @RestController // Danh dau len class -> Class nay se xu ly request va response (controller)
 * Class ResponseEntity<?>: Class dai dien cho 1 doi tuong HTTP Response, co the chua body, header, status code
 * */
@Controller
// @RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>(List.of(
            new Book("1", "De men phieu luu ky", "To Hoai", 2000),
            new Book("2", "Doremon", "Fujiko F. Fujio", 1970),
            new Book("3", "Conan", "Gosho Aoyama", 1994)
    ));

    public BookController() {
        System.out.println("BookController constructor");
    }

    // Vi du voi controller tra ve view
    @GetMapping("/home") // "/home" -> URL
    public String getHome() {
        return "home"; // ten template
    }

    // 1. Lấy danh sách book: GET - /books
//    @GetMapping("/books") // HTTP method + API URL
//    public List<Book> getAllBooks() {
//        return books;
//    }

//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    @GetMapping("/books") // HTTP method + API URL
//    public List<Book> getAllBooks() {
//        return books;
//    }

    // @GetMapping // HTTP method + API URL
    @RequestMapping(method = RequestMethod.GET) // HTTP method + API URL
    public ResponseEntity<?> getAllBooks() {
        // return ResponseEntity.ok(books);
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

    // 2. Lấy chi tiết book theo id: GET - /books/{id}
    @ResponseBody
    // @GetMapping("/{id}")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Book getBookById(@PathVariable String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
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
    public ResponseEntity<List<Book>> sortByYear() {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getYear() - o1.getYear();
            }
        });

        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Book>> getBooksByKeyword(@PathVariable String keyword) {
        List<Book> rs = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                rs.add(book);
            }
        }
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/startYear/{startYear}/endYear/{endYear}")
    public ResponseEntity<List<Book>> getBooksByYear(@PathVariable int startYear, @PathVariable int endYear) {
        List<Book> rs = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= startYear && book.getYear() <= endYear) {
                rs.add(book);
            }
        }
        return ResponseEntity.ok(rs);
    }
}
