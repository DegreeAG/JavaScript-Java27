package com.example.test_miniproject.repository;

import com.example.test_miniproject.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);
}