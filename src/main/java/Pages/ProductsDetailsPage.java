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
    //hover on firstproduct
    private final By firstpro=By.cssSelector(".product-image-wrapper");
    public void HoveronFirst(){
        Hover(firstpro);
    }
    //add to cart click
    private final By AddCart =
            By.xpath("//button[@type='button']");
    public void ClickonAddCart(){
        ul.waitForClickable(AddCart).click();
    }
    //clicking on view cart
    private final By ViewCart=By.xpath("//u[text()='View Cart']");
    public void ClickonViewCart(){
        ul.waitForClickable(ViewCart).click();
    }
//adding quantity
private final By quantity = By.id("quantity");

    public void enterQuantity(String qty) {
        clear(ul.waitForVisibility(quantity));
        type(ul.waitForVisibility(quantity), qty);
    }
    //adding name for review
    private final By names = By.id("name");
    public void enterName(String name) {
        type(ul.waitForVisibility(names),name);
    }
    //adding email
    private final By EM = By.id("email");
    public void enterEmail(String email) {
        type(ul.waitForVisibility(EM),email);
    }
    //adding review
    private final By reviews=By.id("review");
    public void enterReview(String review) {
        type(ul.waitForVisibility(reviews),review );
    }
    //click on submit
    private final By clickSubmit=By.id("button-review");
    public void clickSubmit(){
        ul.waitForClickable(clickSubmit);
        safeClick(clickSubmit);
    }
    //review message
    private final By reviewSuccessMessage =
            By.xpath("//span[text()='Thank you for your review.']");
    public boolean isReviewSubmitted() {
        return ul.waitForVisibility(reviewSuccessMessage).isDisplayed();
    }
}
