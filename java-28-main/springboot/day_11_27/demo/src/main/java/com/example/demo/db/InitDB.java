package com.example.demo.db;

import com.example.demo.model.Book;
import com.example.demo.utils.file.IFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class InitDB implements CommandLineRunner {

    private final IFileReader fileReader;

    public InitDB(@Qualifier("jsonFileReader") IFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start InitDB...");
        List<Book> books = fileReader.readFile("books.json");

        log.info("Books size: {}", books.size());
        BookDB.books = books;
    }
}
