package DataProvider;

import Utils.ExcelUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider (name="LoginData")
    public Object[][] LoginData(){
        String path="src/main/resources/TestData/LoginData.xlsx";
        ExcelUtils excel=new ExcelUtils(path);
        String sheetName="Sheet1";
        int rownum=excel.getRowCount(sheetName);
        int colnum=excel.getColumnCount(sheetName);
        Object [][]data=new Object[rownum][colnum];
        for (int j=1;j<=rownum;j++){
            for (int i=0;i<colnum;i++){
                data[j-1][i]=excel.getCellValue(sheetName,j,i);
            }
        }
        excel.close();
        return data;
    }
}
