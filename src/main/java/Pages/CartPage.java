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
    private final By checkout=By.cssSelector(".check_out");
    public void ClickCheckout() {
        ul.waitForVisibility(checkout);
        safeClick(checkout);
    }
    //subscribe email
    private final By  subemail = By.id("susbscribe_email");
    public void EnterEmail(String email){
        type(ul.waitForVisibility(subemail),email );
    }
    //subscribe button
    private final By subs=By.id("subscribe");
    public void clickOnSubs() {
        ul.waitForClickable(subs);
        safeClick(subs);
    }
}