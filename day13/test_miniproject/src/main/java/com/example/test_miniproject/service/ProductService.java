package com.example.test_miniproject.service;

import com.example.test_miniproject.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();


    Product getProductById(int id);
}