package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final WaitUtils ul;
public LoginPage(WebDriver driver) {
    super(driver);
    ul=new WaitUtils(driver);
}
     //login locators
    private final By email = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By password = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By loginerror=By.xpath("//p[text()=\"Your email or password is incorrect!\"]");
    private  final By submit = By.xpath("//button[text()=\"Login\"]");
    //signup Locators
    private final By signemail=By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signname=By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By signsubmit=By.xpath("//button[@data-qa=\"signup-button\"]");
    //login function with existing credentails for signup
    private final By existmsg=By.xpath("//p[text()=\"Email Address already exist!\"]");
    //heading for signup
    private final By Welcomeheading=By.xpath("//h2[text()=\"New User Signup!\"]");

    public boolean ValidateSign(){
        return ul.waitForVisibility(Welcomeheading).isDisplayed();
    }

     public void login(String emailvalue, String passwordvalue) {
         type(driver.findElement(email), emailvalue);
         type(driver.findElement(password), passwordvalue);
         ul.waitForVisibility(submit);
         click(submit);

     }
//signup with name and email
     public void Existsignup(String namevalue, String signemailvalue) {
         type(driver.findElement(signname), namevalue);
         type(driver.findElement(signemail), signemailvalue);
         ul.waitForVisibility(signsubmit);
         click(signsubmit);
     }
     //checking  login error when given wrong credential in login
     public boolean iserror(){

         return (ul.waitForVisibility(loginerror).isDisplayed());
     }
  //checking signup with already existing credential
  public boolean isExistingEmailErrorDisplayed() {
      return ul.waitForVisibility(existmsg).isDisplayed();
  }
}
