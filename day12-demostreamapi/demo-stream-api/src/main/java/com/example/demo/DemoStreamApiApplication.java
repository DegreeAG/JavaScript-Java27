package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.apache.coyote.http11.Constants.a;

@SpringBootApplication
public class DemoStreamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStreamApiApplication.class, args);


		//C1: Su dung class implement Greeting
		Greeting vietnam = new Vietnam();
		vietnam.sayHello("Nguyen Van A");

		//C2: Su dung anonymous class
		Greeting china = new Greeting() {
			@Override
			public void sayHello(String name) {
				System.out.println("你好 "+ name);
			}
		};
		china.sayHello("Tran Van B");

		//C3: Lambda Expression
		Greeting endlish = (name) -> System.out.println("Hello " + name);
		endlish.sayHello("Le Thi C");

	    Calcalator sum = (a1, b) -> String.valueOf(Integer.sum(a, b));
        System.out.println("sum: " + sum.calculate(5, 3));

		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		List<String> collectedName = names.stream()
				.filter(name->name.length() > 4)
				.map(name -> name.toUpperCase())
				.peek(name -> System.out.println("Filtered Name " + name))
				.toList();
//
//		List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);
//		//1.Duyệt numbers
//		Stream<Integer> stream = numbers.stream().distinct();
//		stream.forEach(s -> System.out.print(s + "\t"));

	}

	// Functional Interface: La Interface chứa 1 phương thức abstract
	// Lambda expression sinh ra để triển khai interface này

}
