package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final WaitUtils ul;
public LoginPage(WebDriver driver) {
    super(driver);
    ul=new WaitUtils(driver);
}
    private final By email = By.name("email");
    private final By password = By.name("password");
    private final By loginerror=By.xpath("//p[text()=\"Your email or password is incorrect!\"]");
     private  final By submit = By.xpath("//button[text()=\"Login\"]");
     public void login(String emailvalue, String passwordvalue) {
         type(driver.findElement(email), emailvalue);
         type(driver.findElement(password), passwordvalue);
         click(ul.waitForVisibility(submit));
     }

     public boolean iserror(){

         return (ul.waitForVisibility(loginerror).isDisplayed());
     }

}
