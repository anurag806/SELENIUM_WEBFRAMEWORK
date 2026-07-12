package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected  void click(WebElement element){
        element.click();
    }
    protected  void type(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }
    protected void clear(WebElement element){
        element.clear();
    }
    protected String getText(WebElement element){
        return element.getText();
    }
    protected boolean isElementPresent(WebElement element){
        return element.isDisplayed();
    }
    protected boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }
    protected String getAttributeValue(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }
    protected String getTitle(){
        return driver.getTitle();
    }
}
