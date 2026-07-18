package Pages;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {
    private final WaitUtils ul;

    public SignUpPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }

    // Title
    private final By titleMr = By.id("id_gender1");
    private final By titleMrs = By.id("id_gender2");
    public void GetTitle( String Title){
        if(Title.equalsIgnoreCase("Mr")){
            click(titleMr);
        } else if (Title.equalsIgnoreCase("Mrs")) {
            click(titleMrs);
        }
        else {
            throw new RuntimeException("Invalid Title");
        }
    }

    // Account Information
    private final By password = By.id("password");

   public void Typepassword(String pwd){
       WebElement ele=ul.waitForVisibility(password);
       type(ele,pwd);
   }

    // DOB
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    public void SelectDate(String day, String month, String year){
        SelectedByVisibleText(days,day);
        SelectedByVisibleText(months,month);
        SelectedByVisibleText(years,year);
    }
    // Checkboxes
    private final By newsletter = By.id("newsletter");
    private final By specialOffers = By.id("optin");
    public void ClickNewsletter() {
        click(newsletter);
    }
    public void ClickSpecialOffers() {
        click(specialOffers);
    }
    // Address
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    public void EnterAddress(String fname,String lname,String com,String add1,String add2){
        type(ul.waitForVisibility(firstName),fname);
        type(ul.waitForVisibility(lastName),lname);
        type(ul.waitForVisibility(company),com);
        type(ul.waitForVisibility(address1),add1);
        type(ul.waitForVisibility(address2),add2);
    }
    // Country
    private final By country = By.id("country");
    public void EnterCountry(String cont){
        SelectedByVisibleText(country,cont);
    }
    // Location
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    public void EnterLocation(String st,String cit,String zip,String mob){
        type(ul.waitForVisibility(state),st);
        type(ul.waitForVisibility(city),cit);
        type(ul.waitForVisibility(zipcode),zip);
        type(ul.waitForVisibility(mobileNumber),mob);
    }

    // Button
    private final By createAccountBtn =
            By.xpath("//button[@data-qa='create-account']");
    public void ClickCreateAccount() {
        ul.waitForClickable(createAccountBtn);
        click(createAccountBtn);
    }
}
