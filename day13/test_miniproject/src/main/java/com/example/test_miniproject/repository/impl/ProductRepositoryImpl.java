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

    @Override
    public Product findById(int id) {
        return ProductDB.products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

}