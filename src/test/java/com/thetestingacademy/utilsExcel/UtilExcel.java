package com.thetestingacademy.utilsExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {
    public static String sheetPath = System.getProperty("user.dir")+ "/src/test/java/com/thetestingacademy/resources/Sheet1.xlsx";
    static Workbook book;
    static Sheet sheet;




    public static Object[][] getTestDataFromExcel(String sheetname) {

        try {
            FileInputStream fileInputStream = new FileInputStream(sheetPath);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(sheetname);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

            }

        }


        return data;
    }
}
