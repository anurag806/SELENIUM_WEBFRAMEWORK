package TestCases;

import Base.Base;
import Config.ConfigRead;
import Pages.Home;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ExistingUserSignupError extends Base {
@Test public  void existingUserSignupError()
{
    Home home=new Home(getDriver());
    home.signin();
    log.info("Signup page opened");
    LoginPage loginpage=new LoginPage(getDriver());
    log.info("Login page opened");
    loginpage.Existsignup(ConfigRead.getProperty("name"),ConfigRead.getProperty("email"));
    log.info("signup details fill");
    Assert.assertTrue(
            loginpage.isExistingEmailErrorDisplayed(),
            "Existing email error message was not displayed");
    log.info("signup error existing email");
}
}
