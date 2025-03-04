package vn.techmaster.demo.utils.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.model.Book;

import java.io.FileInputStream;
import java.util.List;

import static vn.techmaster.demo.db.BookDB.books;

@Slf4j
@Component("excelFileReader")
public class ExcelFileReader implements IFileReader {

    @Override
    public List<Book> readFile(String filePath) {
        log.info("Excel file reading...");

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
            for (Row row : workbook.getSheetAt(0)) {
                if (row.getRowNum() == 0) continue; // Bỏ qua tiêu đề
                books.add(new Book(
                        row.getCell(0).getStringCellValue().trim(),
                        row.getCell(1).getStringCellValue().trim(),
                        row.getCell(2).getStringCellValue().trim(),
                        (int) row.getCell(3).getNumericCellValue()
                ));
            }
        } catch (Exception e) {
            log.error("Error reading Excel file: {}", filePath, e);
        }
        log.info("Total books read: {}", books.size());
        return books;
    }
}
