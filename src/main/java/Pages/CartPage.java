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
    //delete the cart item
    private final By Delpro=By.cssSelector(".cart_quantity_delete");
    public void ClickDeleteProduct() {
        ul.waitForVisibility(Delpro);
        click(Delpro);
    }
    //cart is empty
    private final By Cartempty=By.xpath("//b[text()=\"Cart is empty!\"]");
    public boolean IsEmptyCart() {
        return ul.waitForVisibility(Cartempty).isDisplayed();
    }
    private final By quantity =
            By.cssSelector(".cart_quantity button");
    public String getProductQuantity() {

        return ul.waitForVisibility(quantity).getText();
    }
}