package com.example.demo;

import com.example.demo.controller.BookController;
import com.example.demo.model.Book;
import com.example.demo.model.Shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Book book = Book.builder()
				.title("Lap trinh")
				.year(2021)
				.id("1")
				.build();

		// Get bean
		BookController controller = context.getBean(BookController.class);
		System.out.println(controller);

		Book book1 = context.getBean(Book.class);
		System.out.println(book1);

		Shop shop = context.getBean(Shop.class);
		System.out.println(shop);
	}

}
