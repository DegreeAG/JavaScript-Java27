package com.example.test_miniproject.utils;

import com.example.test_miniproject.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}
