package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController // Danh dau len class -> Class nay se xu ly request va response (controller)
public class BookController {
    private List<Book> books = new ArrayList<>(List.of(
            new Book("1", "De men phieu luu ky", "To Hoai", 2000),
            new Book("2", "Doremon", "Fujiko F. Fujio", 1970),
            new Book("3", "Conan", "Gosho Aoyama", 1994)
    ));

    // 1. Lấy danh sách book: GET - /books
    @GetMapping("/books") // HTTP method + API URL
    public List<Book> getAllBooks() {
        return books;
    }

    // 2. Lấy chi tiết book theo id: GET - /books/{id}
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
