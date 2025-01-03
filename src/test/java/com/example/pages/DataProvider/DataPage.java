package com.example.pages.DataProvider;

import com.example.BaseTest;
import com.example.pages.BasePage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


import java.io.FileInputStream;
import java.io.IOException;

public class DataPage extends BaseTest {

    private String filePath = "src/test/java/com/example/pages/DataProvider/Book1.xlsx";
    private static String sheetName = "Data2";


    @Test(dataProvider = "excelData")
    public void read(String username, String password){
        System.out.println("username: " + username + ", password: " + password);

    }

    @DataProvider(name = "excelData")
    public Object[][] readExcel() throws IOException {
        return readExcelData(filePath, sheetName);
    }

    public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][columnCount];

        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String cellValue = formatter.formatCellValue(cell);
                data[i - 1][j] = cellValue;
            }
        }

        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " not found.");
        }

        workbook.close();
        file.close();

        return data;
    }
}
