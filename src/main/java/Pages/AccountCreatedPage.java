package Pages;
import Pages.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class AccountCreatedPage extends BasePage {

        private final WaitUtils ul;

        public AccountCreatedPage(WebDriver driver) {
            super(driver);
            ul = new WaitUtils(driver);
        }

        // Locators
        private final By accountCreated =
                By.xpath("//b[text()='Account Created!']");

        private final By continueBtn =
                By.xpath("//a[@data-qa='continue-button']");

        // Verify Account Created
        public boolean isAccountCreated() {
            return ul.waitForVisibility(accountCreated).isDisplayed();
        }

        // Click Continue
        public void clickContinue() {
            ul.waitForClickable(continueBtn);
            click(continueBtn);
        }
    }

