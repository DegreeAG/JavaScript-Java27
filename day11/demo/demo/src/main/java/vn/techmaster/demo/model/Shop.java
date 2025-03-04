package vn.techmaster.demo.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
@RequiredArgsConstructor

public class Shop {
    //C1: Field injection
//    @Autowired
//    private Book book;

    //C2: Constructor injection
    private String name;
    private final Book book;

//    public Shop(Book book) {
//        this.book = book;
}

