package TestCases;

import Base.Base;
import Pages.Home;
import Pages.ProductPage;
import Pages.ProductsDetailsPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ProductDetailsTest  extends Base {
 private final Logger log= LoggerUtils.getLogger(ProductDetailsTest.class);
 @Test public void ProductDetailsTest(){
     Home hm=new Home(getDriver());
     ProductPage productPage=new ProductPage(getDriver());
     ProductsDetailsPage  productsDetailsPage=new ProductsDetailsPage(getDriver());
     hm.clickOnProduct();
     log.info("product details page is clicked");
     Assert.assertTrue(productPage.AllproductDisplay(),"product are displayed");
     log.info("product details page are displayed");
     productPage.clickProduct();
     log.info("click on one product");
     Assert.assertTrue(productsDetailsPage.VerifyProductName(),"product name is displayed");
     Assert.assertTrue(productsDetailsPage.VerifyCondition(),"product condition is displayed");
     Assert.assertTrue(productsDetailsPage.VerifyAvailability(),"product availability is displayed");
     Assert.assertTrue(productsDetailsPage.VerifyPrices(),"prices are displayed");
     Assert.assertTrue(productsDetailsPage.VerifyBrand(),"brand is displayed");
     Assert.assertTrue(productsDetailsPage.VerifyCategory(),"category is displayed");
     log.info("product details page is clicked");

 }


}
