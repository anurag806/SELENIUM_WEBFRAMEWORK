package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
     By email = By.name("email");
     By password = By.name("password");
     By submit = By.xpath("//button[text()=\"Login\"]");
     public void login(String emailvalue, String passwordvalue){
         driver.findElement(email).sendKeys(emailvalue);
         driver.findElement(password).sendKeys(passwordvalue);
         WaitUtils ul=new WaitUtils(driver);
         ul.waitForVisibility(submit).click();

     }

}
