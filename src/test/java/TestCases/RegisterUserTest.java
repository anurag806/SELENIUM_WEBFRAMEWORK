package TestCases;

import Base.Base;
import DataProvider.RegisterConstant;
import Pages.Home;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.FakerUtils;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class RegisterUserTest  extends Base {
   private static final Logger log=LoggerUtils.getLogger(RegisterUserTest.class);
    @Test
    public void RegisterUserTest(){
        Home home=new Home(getDriver());
        home.signin();
        log.info("Navigated to Signup/Login page");
        LoginPage loginpage=new LoginPage(getDriver());
        String firstname= FakerUtils.GetfirstName();
        String email=FakerUtils.getEmail();
        loginpage.Existsignup(firstname, email);
        log.info( " Intial details Signup Successful");
        SignUpPage signuppage=new SignUpPage(getDriver());
         signuppage.GetTitle(RegisterConstant.TITLE);
         signuppage.Typepassword(RegisterConstant.PASSWORD);
         signuppage.SelectDate(RegisterConstant.DAY,RegisterConstant.MONTH,RegisterConstant.YEAR);
         signuppage.ClickNewsletter();
         signuppage.ClickSpecialOffers();
         signuppage.EnterAddress(firstname,RegisterConstant.LAST_NAME,RegisterConstant.COMPANY,RegisterConstant.ADDRESS1,RegisterConstant.ADDRESS2);
         signuppage.EnterCountry(RegisterConstant.COUNTRY);
         String Mob=FakerUtils.MobileNumber();
         signuppage.EnterLocation(RegisterConstant.STATE,RegisterConstant.CITY,RegisterConstant.ZIPCODE,Mob);
         signuppage.ClickCreateAccount();


    }
}
