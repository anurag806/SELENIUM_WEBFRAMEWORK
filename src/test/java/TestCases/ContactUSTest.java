package TestCases;
import Base.Base;
import DataProvider.DataProviderUtils;
import Pages.ContactUsPage;
import Pages.Home;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class ContactUSTest extends Base
{
    private final Logger log= LoggerUtils.getLogger(ContactUSTest.class);
    @Test(dataProvider = "ContactUS", dataProviderClass = DataProviderUtils.class )
    public void ContactUSTest(String Name, String Email,String Feedback,String Message){
        Home hm=new Home(getDriver());
        hm.clickOnContactus();
        log.info("clicking on the contact us");
        ContactUsPage conpage=new ContactUsPage(getDriver());
        conpage.getName(Name);
        conpage.getEmail(Email);
        conpage.getSubject(Feedback);
        conpage.getMessage(Message);
        conpage.submit();
        conpage.AcceptAlert();
        conpage.IsSuccessMessage();


    }
}
