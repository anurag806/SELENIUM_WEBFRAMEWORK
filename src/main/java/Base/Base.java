package Base;
import Config.ConfigRead;
import DriverFactory.driverfactory;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Base {
    protected static final Logger log = LoggerUtils.getLogger(Base.class);
    @BeforeMethod
    public void open() {
        String browser=ConfigRead.getProperty("browser");
        driverfactory.initializeDriver(browser);
        log.info("Browser initialized");
        driverfactory.getDriver().manage().deleteAllCookies();
        driverfactory.getDriver().manage().window().maximize();
        log.info("Window Maximized");
        driverfactory.getDriver().get(ConfigRead.getProperty("url"));
        log.info("Window Opened");
    }

   @AfterMethod
    public void close() {

        if (driverfactory.getDriver() != null) {
            driverfactory.quitDriver();
            log.info("Driver Closed");
        }
    }
}