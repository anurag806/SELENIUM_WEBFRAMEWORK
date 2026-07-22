package TestCases;

import Base.Base;
import Pages.CartPage;
import Pages.Home;
import Pages.ProductPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class RemoveProductTest  extends Base {

    private final Logger log= LoggerUtils.getLogger(RemoveProductTest.class);
@Test public void RemoveProduct(){
    Home hm=new Home(getDriver());
    hm.clickOnProduct();
    log.info("Clicked on the product button");
    ProductPage ppage=new ProductPage(getDriver());
    ppage.hoverOnFirstProduct();
    ppage.clickAddToCart();
    Assert.assertTrue(
            ppage.isAddedPopupDisplayed(),
            "Added popup is not displayed");

    log.info("Added popup verified");

    ppage.clickViewCart();
    log.info("Clicked View Cart");

    CartPage cartPage = new CartPage(getDriver());

    Assert.assertTrue(
            cartPage.isProductDisplayed(),
            "Product is not present in cart");

    log.info("Product verified in cart");
    cartPage.ClickDeleteProduct();
    log.info("Clicked Delete Product");

    Assert.assertTrue(
            cartPage.IsEmptyCart(),
            "Cart is not empty");

    log.info("Product removed successfully");
}
}
