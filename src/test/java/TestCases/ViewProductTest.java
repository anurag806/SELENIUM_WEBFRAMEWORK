package TestCases;

import Base.Base;
import Pages.Home;
import Pages.ProductPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ViewProductTest extends Base {

    private static final Logger log =
            LoggerUtils.getLogger(ViewProductTest.class);

    @Test
    public void verifyAllProductsTest() {

        Home home = new Home(getDriver());
        ProductPage productsPage = new ProductPage(getDriver());

        log.info("Opening Products page");
        home.clickOnProduct();

        Assert.assertTrue(productsPage.isProductListDisplayed(),
                "Products page is not displayed");
        log.info("Products page displayed successfully");

        Assert.assertTrue(productsPage.isProductListDisplayed(),
                "Products list is not displayed");
        log.info("Products list displayed successfully");
    }
}