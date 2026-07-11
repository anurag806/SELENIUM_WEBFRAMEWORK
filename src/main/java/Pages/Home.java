package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
WebDriver driver;
public Home(WebDriver driver) {
this.driver=driver;
}
By sign=By.xpath("//a[@href=\"/login\"]");
public void signin(){
    WaitUtils ut=new WaitUtils(driver);
    ut.waitForVisibility(sign).click();

}
}
