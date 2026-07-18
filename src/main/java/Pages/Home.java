package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {
 private  final WaitUtils ul;
public Home(WebDriver driver) {
    super(driver);
    ul = new WaitUtils(driver);
}
private final By sign=By.xpath("//a[@href=\"/login\"]");
private final By logout=By.xpath("//a[@href=\"/logout\"]");
public void signin(){

    ul.waitForVisibility(sign);
    click(sign);
}
public void  logout(){

    ul.waitForVisibility(logout);
    click(logout);
}
public boolean isLoggedOutVisible(){

    return isElementPresent(ul.waitForVisibility(logout));
}
    public boolean isLoginVisible() {
        return isElementPresent(ul.waitForVisibility(sign));
    }
}
