package com.example.test_miniproject.utils;

import com.example.test_miniproject.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class JsonFileReader implements IFileReader {
    @Override
    public List<Product> readFile(String filePath) {
        log.info("Reading JSON file from classpath: {}", filePath);
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource(filePath);
            return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            log.error("Error reading JSON file from classpath: {}", filePath, e);
            return List.of();
        }
    }
}
