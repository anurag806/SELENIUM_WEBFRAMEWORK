package Pages;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private WaitUtils ul;
    public ProductPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }
    //heading for all products
    private final By productheading= By.cssSelector(".title.text-center");
    public boolean  AllproductDisplay(){
     return ul.waitForVisibility(productheading).isDisplayed();
    }
    // all products cart
    private final By productslist=By.cssSelector(".features_items");
    public boolean isProductListDisplayed() {
        return ul.waitForVisibility(productslist).isDisplayed();
    }

}
