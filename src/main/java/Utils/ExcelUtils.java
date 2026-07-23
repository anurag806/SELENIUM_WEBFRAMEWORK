package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private FileInputStream fis;
    private Workbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell cell;

    // Handles String, Number, Date, Boolean automatically
    private final DataFormatter formatter = new DataFormatter();

    public ExcelUtils(String path) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to open Excel file: " + e.getMessage(), e);
        }
    }

    // Get total number of data rows (excluding header)
    public int getRowCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found.");
        }

        return sheet.getLastRowNum();
    }

    // Get total number of columns
    public int getColumnCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found.");
        }

        row = sheet.getRow(0);

        if (row == null) {
            return 0;
        }

        return row.getLastCellNum();
    }

    // Read cell value safely
    public String getCellValue(String sheetName, int rowNum, int colNum) {

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found.");
        }

        row = sheet.getRow(rowNum);

        if (row == null) {
            return "";
        }

        cell = row.getCell(colNum);

        if (cell == null) {
            return "";
        }

        return formatter.formatCellValue(cell);
    }

    // Write data into Excel
    public void setCellData(String sheetName, int rowNum, int colNum, String value) {

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found.");
        }

        row = sheet.getRow(rowNum);

        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        cell = row.getCell(colNum);

        if (cell == null) {
            cell = row.createCell(colNum);
        }

        cell.setCellValue(value);
    }

    // Close workbook
    public void close() {
        try {

            if (workbook != null) {
                workbook.close();
            }

            if (fis != null) {
                fis.close();
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to close Excel file: " + e.getMessage(), e);
        }
    }
}