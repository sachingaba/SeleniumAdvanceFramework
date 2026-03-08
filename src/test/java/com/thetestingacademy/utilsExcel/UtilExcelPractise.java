package com.thetestingacademy.utilsExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcelPractise {
    static String sheetPath = System.getProperty("user.dir")+ "/src/test/java/resources/Sheet1.xlsx";

    static Workbook book;
    static Sheet sheet;

    static Object[][] getDataFromExcel(String sheetname){
        try {
            FileInputStream fis = new FileInputStream(sheetPath);
            book = WorkbookFactory.create(fis);
            sheet = book.getSheet(sheetname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

data[i][j] = sheet.getRow(i).getCell(j).toString();

            }

        }

return data;
    }


}
