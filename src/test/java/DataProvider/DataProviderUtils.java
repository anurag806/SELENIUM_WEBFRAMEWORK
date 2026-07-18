package DataProvider;
import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;


public class DataProviderUtils {
    private static final String PATH = "src/main/resources/TestData/TestData.xlsx";
    //fetching data for validLogin
    @DataProvider (name="LoginData")
    public Object[][] LoginData(){
      return getData("ValidLogin");

    }
    //fetching data for wrong invalid login
    @DataProvider (name="InvalidLoginData")
    public Object[][] InvalidLoginData(){
        return getData("InvalidLogin");
    }
    private Object[][] getData(String sheetName){
        ExcelUtils excel=new ExcelUtils(PATH);
        int rownum=excel.getRowCount(sheetName);
        int colnum=excel.getColumnCount(sheetName);
        Object [][]data=new Object[rownum][colnum];
        for (int j=1;j<=rownum;j++){
            for (int i=0;i<colnum;i++){
                data [j-1][i] =excel.getCellValue(sheetName,j,i);
            }
        }
        excel.close();
        return data;
    }
}