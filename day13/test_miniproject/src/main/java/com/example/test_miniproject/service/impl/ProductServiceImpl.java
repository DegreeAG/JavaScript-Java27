package com.example.test_miniproject.service.impl;

import com.example.test_miniproject.model.Product;
import com.example.test_miniproject.repository.ProductRepository;
import com.example.test_miniproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllBooks() {
        return productRepository.findAll();
    }
}
