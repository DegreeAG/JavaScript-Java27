package com.example.demo.utils.file;

import com.example.demo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CsvFileReader implements IFileReader{
    @Override
    public List<Book> readFile(String filePath) {
        log.info("Csv file");
        return List.of();
    }
}
