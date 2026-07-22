package TestCases;
import Base.Base;
import Pages.BasePage;
import Pages.CartPage;
import Pages.Home;
import Pages.ProductPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class AddToCartTest extends Base
{
    private static final Logger log =
            LoggerUtils.getLogger(AddToCartTest.class);
    @Test
    public void AddToCartTest() {

        Home home = new Home(getDriver());

        home.clickOnProduct();
        log.info("Navigated to Products page");

        ProductPage productPage = new ProductPage(getDriver());

        productPage.hoverOnFirstProduct();
        log.info("Hovered on first product");

        productPage.clickAddToCart();
        log.info("Clicked Add to Cart");

        Assert.assertTrue(productPage.isAddedPopupDisplayed(),
                "Added popup is not displayed");

        productPage.clickViewCart();
        log.info("Clicked View Cart");

        CartPage cartPage = new CartPage(getDriver());

        Assert.assertTrue(cartPage.isProductDisplayed(),
                "Product is not displayed in cart");

        log.info("Product successfully added to cart");
    }

}
