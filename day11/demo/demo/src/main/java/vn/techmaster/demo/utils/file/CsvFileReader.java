package vn.techmaster.demo.utils.file;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.model.Book;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static vn.techmaster.demo.db.BookDB.books;


@Slf4j
@Component("csvFileReader")
public class CsvFileReader implements IFileReader {

    @Override
    public List<Book> readFile(String filePath) {
        log.info("Csv file reading...");

        try (final CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            csvReader.skip(1);// Bỏ qua dòng đầu tiên

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // Đảm bảo có đủ cột dữ liệu
                if (nextRecord.length >= 4) {
                    String id = nextRecord[0];    // Cột 1: ID
                    String title = nextRecord[1]; // Cột 2: Tên sách
                    String author = nextRecord[2]; // Cột 3: Tác giả
                    int year = Integer.parseInt(nextRecord[3]);  // Cột 4: Năm xuất bản

                    books.add(new Book(id, title, author, year));

//                    // In ra thông tin sách
//                    log.info("ID: {}, Title: {}, Author: {}, Year: {}", id, title, author, year);
                }
            }
        } catch (IOException e) {
            log.error("Error reading CSV file: {}", filePath, e);
        } catch (CsvValidationException e) {
            throw new RuntimeException("CSV validation error", e);
        }
        log.info("Total books read: {}", books.size());
        return books;
    }
}
