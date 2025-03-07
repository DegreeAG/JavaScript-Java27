package com.example.test_miniproject.repository.impl;

import com.example.test_miniproject.db.ProductDB;
import com.example.test_miniproject.model.Product;
import com.example.test_miniproject.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return ProductDB.products;
    }
}
