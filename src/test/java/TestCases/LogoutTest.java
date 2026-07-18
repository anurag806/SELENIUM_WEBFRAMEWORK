package TestCases;

import Base.Base;
import Config.ConfigRead;
import Pages.Home;
import Pages.LoginPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DriverFactory.driverfactory.getDriver;

public class LogoutTest extends Base {
    private static Logger log = LoggerUtils.getLogger(LogoutTest.class);
    @Test
    public void LogOutTest(){
        Home hm=new Home(getDriver());
        hm.signin();
        log.info("Going to login");
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.login(ConfigRead.getProperty("email"),ConfigRead.getProperty("password"));
        log.info("login complete");
        Assert.assertTrue(hm.isLoggedOutVisible(),
                "Login was not successful");
        hm.logout();
        log.info("logout...");

    Assert.assertTrue(hm.isLoginVisible(), "Logout was not successful");
    log.info("Logout verified successfully");
    }
}
