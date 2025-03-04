package vn.techmaster.demo.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.utils.file.IFileReader;


import java.util.List;


@Slf4j
@Configuration
public class InitDB implements CommandLineRunner {

    private final IFileReader FileReader;

    public InitDB(@Qualifier("excelFileReader") IFileReader fileReader) {
        FileReader = fileReader;
    }


    @Override
    public void run(String... args) throws Exception {

        log.info("Start init data...");


        //Đọc file Json
//        List<Book> books = FileReader.readFile("C:\\Users\\user\\Desktop\\Java-27\\Springboot\\day10\\demo\\demo\\books.json");
//        log.info("Book from Json size: {}", books.size());

        // Đọc file CSV
//        List<Book> booksCsv = FileReader.readFile("C:\\Users\\user\\Desktop\\Java-27\\Springboot\\day10\\demo\\demo\\books.csv");
//        log.info("Book from Csv size: {}", books.size());

        //Đọc file excel
        List<Book> books = FileReader.readFile("C:\\Users\\user\\Desktop\\Java-27\\Springboot\\day10\\demo\\demo\\books.xlsx");
        log.info("Book from Excel size: {}", books.size());


        // Lưu sách vào BookDB
        BookDB.books = books;


    }
}
