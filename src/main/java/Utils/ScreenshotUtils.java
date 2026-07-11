package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
   public static  String getScreenshot(WebDriver driver, String testname){
       File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       File folder=new File("Screenshots");
       folder.mkdirs();
       File path= new File("Screenshots/" + testname +"_"+System.currentTimeMillis()+ ".png");
       try {
           FileUtils.copyFile(src,path);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
      return  path.getAbsolutePath();

   }
}
