package Pages;
import Pages.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetailsPage extends BasePage {
 private WaitUtils ul;
    public ProductsDetailsPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }
    //product name
    private final By productname= By.xpath("//div[@class=\"product-information\"]/h2");
    public boolean VerifyProductName(){
       return ul.waitForVisibility(productname).isDisplayed();
    }
    //price
    private final By prices=By.xpath("//span/span");
    public boolean VerifyPrices(){
        return ul.waitForVisibility(prices).isDisplayed();
    }
// cateogery
    private final By category=By.xpath("//p[contains(text(),'Category')]");
    public boolean VerifyCategory(){
        return ul.waitForVisibility(category).isDisplayed();
    }
    //Availablity
    private final By availability =
            By.xpath("//b[text()='Availability:']");
    public boolean VerifyAvailability(){
        return ul.waitForVisibility(availability).isDisplayed();

    }
    //condition
    private final By condition =
            By.xpath("//b[text()='Condition:']");
    public boolean VerifyCondition(){
        return ul.waitForVisibility(condition).isDisplayed();
    }
    //brand
    private final By brand =
            By.xpath("//b[text()='Brand:']");
    public boolean VerifyBrand(){
        return ul.waitForVisibility(brand).isDisplayed();
    }
}
