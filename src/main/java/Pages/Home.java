package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

public Home(WebDriver driver) {
    super(driver);
}
By sign=By.xpath("//a[@href=\"/login\"]");
public void signin(){
    WaitUtils ut=new WaitUtils(driver);
    click(ut.waitForVisibility(sign));

}
}
