package TestCases;

import Base.Base;
import Pages.CartPage;
import Pages.Home;
import Pages.ProductPage;
import Pages.ProductsDetailsPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class VerifyProductQuantityTest  extends Base
{

    private final Logger log= LoggerUtils.getLogger(VerifyProductQuantityTest.class);
    @Test
    public void VerifyProductQuantityTest()
    {
        Home hm=new   Home(getDriver());
        hm.clickOnProduct();
        log.info("click on product button");
        ProductPage ppage=new ProductPage( getDriver());
        ppage.clickProduct();
        System.out.println(getDriver().getCurrentUrl());
        log.info("click on product");
        ProductsDetailsPage details = new ProductsDetailsPage(getDriver());

// Verify details page
        Assert.assertTrue(details.VerifyProductName());
        Assert.assertTrue(details.VerifyPrices());
        Assert.assertTrue(details.VerifyCategory());
        Assert.assertTrue(details.VerifyAvailability());
        Assert.assertTrue(details.VerifyCondition());
        Assert.assertTrue(details.VerifyBrand());
        details.enterQuantity("4");
        details.ClickonAddCart();
        details.ClickonViewCart();

        CartPage cart = new CartPage(getDriver());
        Assert.assertEquals(cart.getProductQuantity(), "4");
    }
}
