package TestCases;

import Base.Base;
import Pages.CategoryProductPage;
import Pages.Home;
import Pages.ProductPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ViewCategoryProductsTest extends Base {

    private final Logger log =
            LoggerUtils.getLogger(ViewCategoryProductsTest.class);

    @Test
    public void testViewCategoryProducts() {

        Home hm = new Home(getDriver());
        hm.clickOnProduct();

        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickMenPlus();
        productPage.clickTshirt();

        CategoryProductPage categoryPage =
                new CategoryProductPage(getDriver());



        System.out.println(categoryPage.getHeading());
        String heading = categoryPage.getHeading().toUpperCase();
        Assert.assertTrue(heading.contains("MEN"));
        Assert.assertTrue(heading.contains("TSHIRTS"));
        Assert.assertTrue(categoryPage.isProductsDisplayed());

        log.info("Category Products displayed successfully.");
    }
}