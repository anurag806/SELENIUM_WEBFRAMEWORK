package TestCases;

import Base.Base;
import Config.ConfigRead;
import Pages.Home;
import Pages.LoginPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


import static DriverFactory.driverfactory.getDriver;


public class LoginTest extends Base {
private static Logger log = LoggerUtils.getLogger(LoginTest.class);
    @Test (priority = 1)public void login() throws InterruptedException {
        LoginPage lp=new LoginPage(getDriver());
        log.info("Login Page");
        Home hm=new Home(getDriver());
        hm.signin();
        lp.login(ConfigRead.getProperty("email"),ConfigRead.getProperty("password"));
        log.info("Login Successful");

    }
}
