package com.example.demo.controller;

import com.example.homework.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>(List.of(
            new Product("010", "MacBook Air 13 inch M1", "8GB/256GB (MGN63SA/A)", 1769, "Apple"),
            new Product("011", "Laptop Acer Aspire 16 AI", "A16 71M 59L5 Ultra 5 125H/16GB/512GB/Win11 (NX.J4YSV.001)", 1869, "Acer"),
            new Product("012", "Laptop Asus Vivobook 15", "X1504ZA i5 1235U/16GB/512GB/Win11 (NJ1608W)", 1469, "Asus"),
            new Product("013", "Laptop HP 240 G9", "i5 1235U/16GB/512GB/Win11 (AG2J7AT)", 1569, "Asus"),
            new Product("014", "MacBook Air 13 inch M2", "16GB/256GB ", 2469, "Apple")
    ));

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return products;
    }
}