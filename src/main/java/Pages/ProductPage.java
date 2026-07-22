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
   // click on first Product
   private final By firstViewProduct =
           By.xpath("(//a[text()='View Product'])[1]");
    public void clickProduct(){
        ul.waitForClickable(firstViewProduct);
        click(firstViewProduct);
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

}
