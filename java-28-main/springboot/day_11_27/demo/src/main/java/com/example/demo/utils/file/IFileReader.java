package com.example.demo.utils.file;

import com.example.demo.model.Book;

import java.util.List;

public interface IFileReader {
    List<Book> readFile(String filePath);
}
