package Pages;
import Pages.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage  extends BasePage{
    WaitUtils ul;
    public ContactUsPage(WebDriver driver){
        super(driver);
        ul=new WaitUtils(driver);
    }
    //name
    private final By name= By.xpath("//input[@data-qa='name']");
    public void getName(String username){
        type(ul.waitForVisibility(name), username);
    }
    //email
    private final By email= By.xpath("//input[@data-qa='email']");
    public void getEmail(String useremail){
        type(ul.waitForVisibility(email),useremail);
    }
//subject
    private final By subject= By.xpath("//input[@data-qa='subject']");
    public void getSubject(String subjects){
        type(ul.waitForVisibility(subject),subjects);
    }
//feedback
    private final By message= By.id("message");
    public void getMessage(String messages){
        type(ul.waitForVisibility(message),messages );
    }
    //submit Button
    private final By submit= By.xpath("//input[@data-qa='submit-button']");
    public void submit(){
        ul.waitForClickable(submit);
        safeClick(submit);
    }
//accept alert
    public void AcceptAlert(){
        ul.waitForAlert().accept();
    }
//sucess message
    private final By sucessmessgae=By.xpath("//div[@class=\"status alert alert-success\"]");
    public boolean IsSuccessMessage(){
       return ul.waitForVisibility(sucessmessgae).isDisplayed();
    }
}
