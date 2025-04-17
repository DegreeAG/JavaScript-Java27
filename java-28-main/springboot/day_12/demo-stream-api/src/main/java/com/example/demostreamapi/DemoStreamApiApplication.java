package com.example.demostreamapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoStreamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamApiApplication.class, args);

        // C1: Su dung class implement Greeting
        Greeting vietnam = new Vietnam();
        vietnam.sayHello("Nguyen Van A");

        // C2: Su dung anonymous class
        Greeting china = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("你好 " + name);
            }
        };
        china.sayHello("Tran Van B");

        // C3: Lambda Expression
        Greeting english = (name) -> System.out.println("Hello " + name);
        english.sayHello("Le Thi C");

        Calcalator sum = (a, b) -> a + b;
        System.out.println("Sum: " + sum.calculate(5, 3));

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> collectedNames = names.stream()
                .filter(name -> name.length() > 4)
                .map(name -> name.toUpperCase())
                .peek(name -> System.out.println("Filtered Name: " + name))
                .toList();
    }

    // Functional Interface: La Interface chua 1 phuong thuc abstract
}
