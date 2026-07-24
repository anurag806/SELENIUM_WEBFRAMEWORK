package TestCases;
import Base.Base;
import DataProvider.DataProviderUtils;
import Pages.Home;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.ProductsDetailsPage;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ProductReviewTest  extends  Base{
    private final Logger log= LoggerUtils.getLogger(ProductReviewTest.class);
@Test(dataProvider = "ProductReview",dataProviderClass = DataProviderUtils.class)
public  void ProductReviewTest(String email,String password,String name,String message)
{
    Home hm=new Home(getDriver());
    hm.signin();
    LoginPage loginpage=new LoginPage(getDriver());
    loginpage.login(email,password);
    log.info("login complete");
    hm.clickOnProduct();
    log.info("poduct page opened");
    ProductPage pg=new ProductPage(getDriver());
    pg.clickFirstviewProduct();
    log.info("first product clicked");
    ProductsDetailsPage pd=new ProductsDetailsPage( getDriver());
    pd.enterName(name);
    pd.enterEmail(email);
    pd.enterReview(message);
    pd.clickSubmit();
    log.info("review completed");
    Assert.assertTrue(pd.isReviewSubmitted(),"review completed");
}
}
