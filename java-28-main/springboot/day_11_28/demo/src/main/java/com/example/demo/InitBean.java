package com.example.demo;

import com.example.demo.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitBean {
    public InitBean() {
        System.out.println("This is InitBean");
    }

    @Bean
    public Book book1() {
        System.out.println("Init book1");
        return Book.builder()
                .title("Lap trinh")
                .year(2021)
                .id("1")
                .build();
    }
}
