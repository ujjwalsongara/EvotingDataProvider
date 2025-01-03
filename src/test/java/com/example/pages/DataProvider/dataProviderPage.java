//package com.example.pages.DataProvider;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class dataProviderPage {
//
////    private String filePath = "/Users/apple/Desktop/IdeaProjects/apiautomation-gradle/src/test/java/com/example/testCases/DataProvider/DataProvider.xlsx";
//    private String filePath = "src/test/java/com/example/pages/DataProvider/Book1.xlsx";
//    private static String sheetName = "Data";
//
//    @Test(dataProvider = "excelDataa")
//    public void read(String username, String password){
//        System.out.println(username + ":"+password);
//    }
//
//    // @Test(dataProvider = "excelData")
//    // public void read(String PARTY_ID){
//    //    System.out.println(PARTY_ID + ":");
//    //}
//
//    @DataProvider(name = "excelDataa")
//    public Object [][] readExcel() throws IOException {
//        return readExcel(filePath, sheetName);
//    }
//
//    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
//
//        FileInputStream file = new FileInputStream(filePath);
//        XSSFWorkbook wb = new XSSFWorkbook(file);
//        XSSFSheet sheet = wb.getSheet(sheetName);
//
//        int rowCount = sheet.getLastRowNum();
//        int column = sheet.getRow(0).getLastCellNum();
//
//        Object[][] data = new Object[rowCount][column];
//
//        for (int i= 1 ; i<= rowCount; i++) {
//            XSSFRow row = sheet.getRow(i);
//            for (int j = 0; j < column; j++) {
//                XSSFCell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String val = formatter.formatCellValue(cell);
//                data[i - 1][j] = val;
//            }
//        }
//        return data;
//    }
//
//}