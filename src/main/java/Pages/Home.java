package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

    private final WaitUtils ul;

    public Home(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }

    // Locators
    private final By sign = By.xpath("//a[@href='/login']");
    private final By logout = By.xpath("//a[@href='/logout']");
    private final By deleteAccount =
            By.xpath("//a[normalize-space()='Delete Account']");

    private final By loggedInAs =
            By.xpath("//a[contains(text(),'Logged in as')]");

    // Click Signup/Login
    public void signin() {
        ul.waitForClickable(sign);
        click(sign);
    }

    // Click Logout
    public void logout() {
        ul.waitForClickable(logout);
        click(logout);
    }

    // Verify Login button
    public boolean isLoginVisible() {
        return ul.waitForVisibility(sign).isDisplayed();
    }

    // Verify Logged In User
    public boolean isLoggedInAsVisible() {
        return ul.waitForVisibility(loggedInAs).isDisplayed();
    }

    // Click Delete Account
    public void clickDeleteAccount() {
        ul.waitForClickable(deleteAccount);
        click(deleteAccount);
    }

    public boolean isLoggedOutVisible() {

        return ul.waitForVisibility(logout).isDisplayed();
    }
    //CLick on Products
    private final By product = By.xpath("//a[@href='/products']");
    public void clickOnProduct() {
        ul.waitForClickable(product);
        click(product);
    }
    //click on Contact Us page
    private final By contactus=By.xpath("//a[@href='/contact_us']");
    public void clickOnContactus() {
        ul.waitForClickable(contactus);
        safeClick(contactus);
    }
}