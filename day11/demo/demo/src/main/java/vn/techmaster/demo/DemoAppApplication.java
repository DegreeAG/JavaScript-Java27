package vn.techmaster.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.techmaster.demo.controller.BookController;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.model.Shop;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoAppApplication.class, args);

		Book book = Book.builder()
				.title("Lập trình")
				.year(2021)
				.id("1")
				.build();



		//Get Bean
		BookController controller = context.getBean(BookController.class);
		System.out.println(controller);

		Book book1 = context.getBean(Book.class);
		System.out.println((book1));

		Shop shop = context.getBean(Shop.class);
		System.out.println(shop);
	}
}
