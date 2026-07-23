package Pages;
import  Pages.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends  BasePage{
   WaitUtils ul;
    public CheckOutPage(WebDriver driver){
    super(driver);
    ul = new WaitUtils(driver);
}
//click on checkout Button
    private final By placeOrder=By.xpath("//a[@href=\"/payment\"]");
    public void ClickPlaceOrder(){
        safeClick(placeOrder);
    }
}
