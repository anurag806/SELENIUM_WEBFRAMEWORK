package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverfactory {

   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver initializeDriver(String browser) {


        switch (browser.toLowerCase()) {

            case "chrome":
                 driver.set( new ChromeDriver());
                break;

            case "firefox":
                 driver.set( new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("Invalid Browser : " + browser);
        }
        return driver.get();
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void quitDriver() {
        if(driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}