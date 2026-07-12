package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

public LoginPage(WebDriver driver) {
    super(driver);
}

     By email = By.name("email");
     By password = By.name("password");
     By submit = By.xpath("//button[text()=\"Login\"]");
     public void login(String emailvalue, String passwordvalue){
         type(driver.findElement(email),emailvalue);
        type(driver.findElement(password),passwordvalue);
         WaitUtils ul=new WaitUtils(driver);
         click(ul.waitForVisibility(submit));
     }

}
