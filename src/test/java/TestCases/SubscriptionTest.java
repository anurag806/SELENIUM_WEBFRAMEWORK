package TestCases;

import Base.Base;
import DataProvider.DataProviderUtils;
import Pages.CartPage;
import Pages.Home;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class SubscriptionTest  extends Base {
    private final Logger log= LoggerUtils.getLogger(SubscriptionTest.class);
    @Test(dataProvider = "Subscription",dataProviderClass =DataProviderUtils.class)
    public void SubscriptionHomeTest( String email)
    {
        Home home=new Home(getDriver());
        home.EnterEmail(email);
        home.clickOnSubs();
        log.info("subscription started");
    }
    @Test (dataProvider = "Subscription",dataProviderClass =DataProviderUtils.class)
    public void SubscriptionCartTest( String email){
        Home home=new Home(getDriver());
        home.clickOnCart();
        log.info("cart page open");
        CartPage cp=new CartPage(getDriver());
        cp.EnterEmail(email);
        cp.clickOnSubs();
        log.info("subscription started");
    }
}
