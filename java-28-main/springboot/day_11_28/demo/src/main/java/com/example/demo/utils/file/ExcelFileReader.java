package com.example.demo.utils.file;

import com.example.demo.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExcelFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String filePath) {
        return List.of();
    }
}
