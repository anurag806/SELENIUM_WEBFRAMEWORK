package TestCases;

import Base.Base;
import Config.ConfigRead;
import Pages.Home;
import Pages.LoginPage;
import Utils.LoggerUtils;
import DataProvider.DataProviderUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DriverFactory.driverfactory.getDriver;
public class LoginTest extends Base {
private static Logger log = LoggerUtils.getLogger(LoginTest.class);
    @Test (dataProvider ="LoginData",dataProviderClass = DataProviderUtils.class, priority = 1)
    public void login(String email,String password) throws InterruptedException {
        LoginPage lp = new LoginPage(getDriver());
        log.info("Login Page");
        Home hm = new Home(getDriver());
        hm.signin();
        lp.login(email, password);
        log.info("Login Successful");
        log.info("checking login status");
        Assert.assertTrue(hm.isLoggedOutVisible(),"Login Failed");
    }
}
