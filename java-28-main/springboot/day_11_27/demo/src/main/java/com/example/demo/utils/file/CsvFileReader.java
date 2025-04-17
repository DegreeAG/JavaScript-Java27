package com.example.demo.utils.file;

import com.example.demo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("csvFileReader")
public class CsvFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String filePath) {
        return List.of();
    }

    // CSV: OpenCSV
    // Excel: Apache POI
}
