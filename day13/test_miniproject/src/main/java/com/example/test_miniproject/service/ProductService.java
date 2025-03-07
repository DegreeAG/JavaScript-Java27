package com.example.test_miniproject.service;

import com.example.test_miniproject.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> searchProducts(String keyword);
    List<Product> getAllProducts(int page, int size);
    long getTotalProducts();
    Product getProductById(int id);
}