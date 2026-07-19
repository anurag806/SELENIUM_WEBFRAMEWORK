package Utils;

import Pages.Home;
import org.openqa.selenium.WebDriver;

import static DriverFactory.driverfactory.getDriver;

public class DeleteUserHelper {
 private final WebDriver driver;
    public DeleteUserHelper( WebDriver driver) {
        this.driver = driver;
    }
    public void DeleteUser() {
        Home home = new Home(getDriver());


    }
}
