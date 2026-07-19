package Utils;
import Constant.RegisterConstant;
import Pages.Home;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;

import static DriverFactory.driverfactory.getDriver;

public class RegisterHelper {

    private final WebDriver driver;

    // Constructor
    public RegisterHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Helper method to create a new user account
    public void createNewUser() {

        // Open Home Page and click on Signup/Login
        Home home = new Home(getDriver());
        home.signin();

        // Generate dynamic test data using Faker
        String firstName = FakerUtils.GetfirstName();
        String email = FakerUtils.getEmail();
        String mobile = FakerUtils.MobileNumber();

        // Enter Name & Email on Signup page
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.Existsignup(firstName, email);

        // Signup Page
        SignUpPage signUp = new SignUpPage(getDriver());

        // ==========================
        // Account Information
        // ==========================
        signUp.GetTitle(RegisterConstant.TITLE);
        signUp.Typepassword(RegisterConstant.PASSWORD);

        // ==========================
        // Date of Birth
        // ==========================
        signUp.SelectDate(
                RegisterConstant.DAY,
                RegisterConstant.MONTH,
                RegisterConstant.YEAR
        );

        // ==========================
        // Newsletter Preferences
        // ==========================
        signUp.ClickNewsletter();
        signUp.ClickSpecialOffers();

        // ==========================
        // Address Information
        // ==========================
        signUp.EnterAddress(
                firstName,
                RegisterConstant.LAST_NAME,
                RegisterConstant.COMPANY,
                RegisterConstant.ADDRESS1,
                RegisterConstant.ADDRESS2
        );

        // ==========================
        // Country
        // ==========================
        signUp.EnterCountry(RegisterConstant.COUNTRY);

        // ==========================
        // State, City, Zip & Mobile
        // ==========================
        signUp.EnterLocation(
                RegisterConstant.STATE,
                RegisterConstant.CITY,
                RegisterConstant.ZIPCODE,
                mobile
        );
        // ==========================
        // Create Account
        // ==========================
        signUp.ClickCreateAccount();
    }
}