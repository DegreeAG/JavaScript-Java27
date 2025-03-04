package vn.techmaster.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demo.model.Book;

@Configuration

public class InitBean {
    public InitBean() {
        System.out.println("This is InitBean");
    }

    @Bean
    public Book book1(){
        System.out.println("Init book1");
        return Book.builder()
                .title("Lập trình")
                .year(2021)
                .id("1")
                .build();
    }
}
