package com.example.test_miniproject.repository;

import com.example.test_miniproject.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    List<Product> searchByName(String keyword);
    List<Product> findAll(int page, int size);
    long count();
    Product findById(int id);
}