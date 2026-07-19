package TestCases;

import Base.Base;
import Pages.AccountCreatedPage;
import Pages.AccountDeletedPage;
import Pages.Home;
import Utils.LoggerUtils;
import Utils.RegisterHelper;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class DeleteUserTest extends Base {

    private static final Logger log =
            LoggerUtils.getLogger(DeleteUserTest.class);

    @Test
    public void deleteUserTest() {

        // Register New User
        RegisterHelper registerHelper = new RegisterHelper(getDriver());
        registerHelper.createNewUser();
        log.info("Registration form submitted.");

        // Verify Account Created
        AccountCreatedPage accountCreatedPage =
                new AccountCreatedPage(getDriver());

        Assert.assertTrue(
                accountCreatedPage.isAccountCreated(),
                "Account was not created."
        );
        log.info("Account Created page displayed.");

        // Click Continue
        accountCreatedPage.clickContinue();
        log.info("Clicked Continue.");

        // Home Page
        Home home = new Home(getDriver());

        // Verify User Logged In
        Assert.assertTrue(
                home.isLoggedInAsVisible(),
                "User is not logged in."
        );
        log.info("User logged in successfully.");

        // Click Delete Account
        home.clickDeleteAccount();
        log.info("Clicked Delete Account.");

        // Verify Account Deleted
        AccountDeletedPage deletedPage =
                new AccountDeletedPage(getDriver());

        Assert.assertTrue(
                deletedPage.isAccountDeleted(),
                "Account was not deleted."
        );
        log.info("Account deleted successfully.");

        // Click Continue
        deletedPage.clickContinue();
        log.info("Clicked Continue.");
    }
}