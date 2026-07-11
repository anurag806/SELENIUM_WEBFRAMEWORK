package Base;

import Config.ConfigRead;
import DriverFactory.driverfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Base {
    @BeforeMethod
    public void open() {
        String browser=ConfigRead.getProperty("browser");
        driverfactory.initializeDriver(browser);
        driverfactory.getDriver().manage().deleteAllCookies();
        driverfactory.getDriver().manage().window().maximize();
        driverfactory.getDriver().get(ConfigRead.getProperty("url"));
    }

   @AfterMethod
    public void close() {

        if (driverfactory.getDriver() != null) {
            driverfactory.quitDriver();
        }
    }
}