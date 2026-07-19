package TestCases;

import Base.Base;
import Pages.AccountCreatedPage;
import Pages.Home;
import Utils.LoggerUtils;
import Utils.RegisterHelper;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class RegisterUserTest extends Base {

    private static final Logger log = LoggerUtils.getLogger(RegisterUserTest.class);

    @Test
    public void RegisterUserTest() {

        // Create Helper Object
        RegisterHelper registerHelper = new RegisterHelper(getDriver());

        // Perform Complete Registration
        registerHelper.createNewUser();
        log.info("User registration completed successfully.");

        // Verify Account Created Page
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(getDriver());

        Assert.assertTrue(
                accountCreatedPage.isAccountCreated(),
                "Account was not created successfully."
        );
        log.info("Account Created page is displayed.");

        // Click Continue
        accountCreatedPage.clickContinue();
        log.info("Clicked on Continue button.");

        // Verify User Logged In
        Home home = new Home(getDriver());

        Assert.assertTrue(
                home.isLoggedOutVisible(),
                "User login verification failed."
        );

        log.info("User logged in successfully.");
    }
}