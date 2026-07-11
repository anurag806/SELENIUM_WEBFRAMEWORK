package TestCases;

import Base.Base;
import Config.ConfigRead;
import Pages.Home;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;


public class LoginTest extends Base {

    @Test (priority = 1)public void login() throws InterruptedException {
        LoginPage lp=new LoginPage(getDriver());
        Home hm=new Home(getDriver());
        ConfigRead conf=new ConfigRead();
        hm.signin();
        lp.login(conf.getProperty("email"),conf.getProperty("password"));

    }
}
