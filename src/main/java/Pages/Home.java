package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

public Home(WebDriver driver) {
    super(driver);
}
By sign=By.xpath("//a[@href=\"/login\"]");
By logout=By.xpath("//a[@href=\"/logout\"]");
public void signin(){
    WaitUtils ut=new WaitUtils(driver);
    click(ut.waitForVisibility(sign));
}
public void  logout(){
    WaitUtils ut=new WaitUtils(driver);
    click(ut.waitForVisibility(logout));
}
public boolean isLoggedOutVisible(){
    WaitUtils ut=new WaitUtils(driver);
    return isElementPresent(ut.waitForVisibility(logout));
}
}
