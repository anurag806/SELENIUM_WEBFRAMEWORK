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
    private final By viewCartHeading=By.xpath("//a[@href=\"/view_cart\"]");

    public void clickViewCart() {
        try {
            safeClick(viewCart);
        } catch (Exception e) {
            safeClick(viewCartHeading);
        }
    }

    //expand women category
    private final By womenPlus =
            By.xpath("(//i[@class='fa fa-plus'])[1]");
    public void clickWomenPlus() {
        ul.waitForClickable(womenPlus);
        safeClick(womenPlus);
    }
    //clicking on the dispalyed in women category
    private final By Dress=By.xpath("//a[@href='/category_products/1']");
    public void clickDress() {
        ul.waitForClickable(Dress);
        safeClick(Dress);
    }
    private final By Tops=By.xpath("//a[@href='/category_products/2']");
    public void clickTops() {
        ul.waitForClickable(Tops);
        safeClick(Tops);
    }
    private  final By Saree=By.xpath("//a[@href='/category_products/7']");
    public void clickSaree() {
        ul.waitForClickable(Saree);
        safeClick(Saree);
    }
    //expand men category
    private final By menPlus =
            By.xpath("(//i[@class='fa fa-plus'])[2]");
    public void clickMenPlus() {
        ul.waitForClickable(menPlus);
        safeClick(menPlus);
    }
    private final By Tshirt=By.xpath("//a[@href='/category_products/3']");
    public void clickTshirt() {
        ul.waitForClickable(Tshirt);
        safeClick(Tshirt);
    }
    private final By Jeans=By.xpath("//a[@href='/category_products/6']");
    public void clickJeans() {
        ul.waitForClickable(Jeans);
        safeClick(Jeans);
    }
    //expand kids category
    private final By kidsPlus =
            By.xpath("(//i[@class='fa fa-plus'])[3]");
    public void clickKidsPlus() {
        ul.waitForClickable(kidsPlus);
        safeClick(kidsPlus);
    }
    private final By KidDress=By.xpath("//a[@href='/category_products/4']");
    public void ClickKidDress(){
        ul.waitForClickable(KidDress);
        safeClick(KidDress);
    }
    private final By Topsshirt=By.xpath("//a[@href='/category_products/5']");
    public void clickTopsshirt() {
        ul.waitForClickable(Topsshirt);
        safeClick(Topsshirt);
    }
}
