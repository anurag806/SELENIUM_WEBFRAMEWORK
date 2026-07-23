package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected  void click(By element){

        driver.findElement(element).click();
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
    protected void SelectedByVisibleText(By locator,String text){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }
    protected void SelectedByValue(By locator,String value){
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }
    protected void SelectByIndex(By locator,int index){
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }
    protected void Hover(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
    protected void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    protected void jsScrollIntoView(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);
    }

}
