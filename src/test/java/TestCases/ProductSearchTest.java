package TestCases;

import Base.Base;
import Constant.ProductConstant;
import Pages.Home;
import Pages.ProductPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ProductSearchTest extends Base {
    private final Logger log= LoggerUtils.getLogger(ProductSearchTest.class);
    @Test public void SearchProduct(){
        Home hm=new Home(getDriver());
        ProductPage productPage=new ProductPage(getDriver());
        hm.clickOnProduct();
        log.info("Clicked on the product button");
        productPage.getProductName(ProductConstant.PRODUCT_NAME);
        log.info("putting product name to search box");
        productPage.clickSearchButton();
        log.info("Clicked on Search button");

        Assert.assertTrue(
                productPage.VerifySearchedHeading(),
                "Searched Products heading is not displayed");

        Assert.assertTrue(
                productPage.clickSearchedProducts(),
                "Search results are not displayed");

        Assert.assertTrue(
                productPage.clickFirstProductName()
                        .contains(ProductConstant.PRODUCT_NAME),
                "Incorrect product displayed");

        log.info("Search product verified successfully");

    }
}
