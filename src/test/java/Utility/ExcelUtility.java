package Utility;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.ArrayList;


public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getDataExcel(String path, String sheetName, int colCnt) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < colCnt; j++) {
                row.add(sheet.getRow(i).getCell(j).toString());
            }
            table.add(row);
        }
        return table;
    }
}