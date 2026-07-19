package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {

    private final WaitUtils ul;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }

    // Locators
    private final By accountDeleted =
            By.xpath("//b[text()='Account Deleted!']");

    private final By continueBtn =
            By.xpath("//a[@data-qa='continue-button']");

    // Verify Account Deleted
    public boolean isAccountDeleted() {
        return ul.waitForVisibility(accountDeleted).isDisplayed();
    }

    // Click Continue
    public void clickContinue() {
        ul.waitForClickable(continueBtn);
        click(continueBtn);
    }
}