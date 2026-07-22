package Pages;
import Pages.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private WaitUtils ul;

    public CartPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }

    //cart is displayed or not
    private final By cartProduct =
            By.cssSelector(".cart_description");

    public boolean isProductDisplayed() {
        return ul.waitForVisibility(cartProduct).isDisplayed();

    }
}