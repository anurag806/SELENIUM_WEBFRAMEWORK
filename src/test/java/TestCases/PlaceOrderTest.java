package TestCases;
import Base.Base;
import Pages.CartPage;
import Pages.Home;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import DataProvider.DataProviderUtils;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class PlaceOrderTest extends  Base{

    private final Logger log= LoggerUtils.getLogger(PlaceOrderTest.class);
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderUtils.class)
    public void placeOrderTest(String email, String password) throws InterruptedException{
        Home hm = new Home(getDriver());
        hm.signin();
        log.info("homepage open");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(email,password);
        log.info("Login Successful");
        hm.clickOnProduct();
        log.info("Product page open");
        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickAddToCart();
        log.info("added to cart");
        productPage.clickViewCart();
        CartPage cartPage = new CartPage(getDriver());
        cartPage.ClickCheckout();
        log.info("Checkout Successful");
    }

}
