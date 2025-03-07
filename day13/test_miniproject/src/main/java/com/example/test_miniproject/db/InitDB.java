package com.example.test_miniproject.db;

import com.example.test_miniproject.model.Product;
import com.example.test_miniproject.utils.IFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class InitDB implements CommandLineRunner {
    private final IFileReader FileReader;

    public InitDB(IFileReader fileReader) {
        FileReader = fileReader;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start init data");

        List<Product> products = FileReader.readFile("data/product.json");
        log.info("Sản phẩm from Json size: {}", products.size());

        ProductDB.products = products;
    }
}
