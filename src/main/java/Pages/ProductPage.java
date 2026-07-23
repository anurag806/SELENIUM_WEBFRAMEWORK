package Pages;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
   // click on first Product
   private final By firstViewProduct =
           By.xpath("(//a[text()='View Product'])[1]");
   public void clickProduct() {

       WebElement product =
               ul.waitForVisibility(firstViewProduct);

       jsScrollIntoView(product);

       try {
           product.click();
       } catch (Exception e) {
           jsClick(product);
       }
   }
    //Search Product
    private final By search=By.id("search_product");
    public void getProductName(String productName){
        type(ul.waitForVisibility(search),productName);;
    }
   //click on search
   private final By searchButton = By.id("submit_search");

    public void clickSearchButton() {
        ul.waitForClickable(searchButton);
        click(searchButton);
    }
    //serach Product Heading
    private final By searchedHeading =
            By.xpath("//h2[text()='Searched Products']");
    public boolean VerifySearchedHeading(){
        return ul.waitForVisibility(searchedHeading).isDisplayed();
    }
    // searched Products
    private final By searchedProducts =
            By.cssSelector(".features_items");
    public boolean clickSearchedProducts(){
       return ul.waitForVisibility(searchedProducts).isDisplayed();
    }
    //varify first product name
    private final By firstProductName =
            By.cssSelector(".productinfo p");
    public String clickFirstProductName(){
       return ul.waitForClickable(firstProductName).getText();
    }
    private final By addedPopup =
            By.xpath("//h4[text()='Added!']");

    public boolean isAddedPopupDisplayed() {
        return ul.waitForVisibility(addedPopup).isDisplayed();
    }
    private final By firstProduct =
            By.xpath("(//div[@class='single-products'])[1]");

    public void hoverOnFirstProduct() {
        Hover(firstProduct);
    }
    public void clickAddToCart() {

        hoverOnFirstProduct();

        List<WebElement> buttons =
                driver.findElements(By.xpath("//a[@data-product-id='1']"));

        for (WebElement button : buttons) {
            if (button.isDisplayed()) {
                try {
                    button.click();
                } catch (Exception e) {
                    jsClick(button);
                }
                return;
            }
        }

        throw new RuntimeException("Visible Add To Cart button not found.");
    }
    private final By viewCart =
            By.xpath("//u[text()='View Cart']");

    public void clickViewCart() {
        ul.waitForClickable(viewCart);
        click(viewCart);
    }
}
