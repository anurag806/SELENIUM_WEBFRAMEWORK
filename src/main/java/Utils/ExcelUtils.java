package Utils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    private FileInputStream fis;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public ExcelUtils(String path) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public int getRowCount(String sheetName){
        sheet= workbook.getSheet(sheetName);
        if(sheet==null){
            throw  new RuntimeException("Sheet Not Found");
        }
        return sheet.getLastRowNum();
   }
public int getColumnCount(String sheetName){
        sheet= workbook.getSheet(sheetName);
    if(sheet==null){
        throw  new RuntimeException("Sheet Not Found");
    }
    row=sheet.getRow(0);
    if(row==null){
        return  0;
    }
    return row.getLastCellNum();
    }
    public String getCellValue(String sheetName,int rowNum, int colNum){
        sheet= workbook.getSheet(sheetName);
        if(sheet==null){
            throw  new RuntimeException("Sheet Not Found");
        }
        row=sheet.getRow(rowNum);
        if(row==null){
            return " ";
        }
     cell=row.getCell(colNum);
        if(cell==null){
            return " ";

        }
return cell.getStringCellValue();
    }
    public void setcelldata(String sheetName, int rowNum, int colNum, String value){
        sheet= workbook.getSheet(sheetName);
        if(sheet==null){
            throw  new RuntimeException("Sheet Not Found");
        }
        row=sheet.getRow(rowNum);
        if(row==null){
            row=sheet.createRow(rowNum);
        }
        cell=row.getCell(colNum);
        if(cell==null){
            cell=row.createCell(colNum);
        }
        cell.setCellValue(value);
    }
    public void close(){
        try {
            if(workbook!=null){
                workbook.close();
            }
            if(fis!=null){
            fis.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

