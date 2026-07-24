package TestCases;

import Base.Base;
import DataProvider.DataProviderUtils;
import Pages.*;
import Utils.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.driverfactory.getDriver;

public class PlaceOrderInvoiceTest extends Base {
    private final Logger logger =
            LoggerUtils.getLogger(PlaceOrderWithPaymentTest.class);

    @Test(dataProvider = "PlaceOrderData",
            dataProviderClass = DataProviderUtils.class)
    public void placeOrderInvoiceTest(
            String email,
            String password,
            String nameOnCard,
            String cardNumber,
            String cvc,
            String month,
            String year) {

        Home home = new Home(getDriver());

        // Login
        home.signin();
        logger.info("Clicked on Signup/Login");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(email, password);
        logger.info("Login Successful");

        // Open Products
        home.clickOnProduct();
        logger.info("Products page opened");

        // Add Product
        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickAddToCart();
        logger.info("Product added to cart");

        // View Cart
        productPage.clickViewCart();
        logger.info("Cart page opened");

        // Checkout
        CartPage cartPage = new CartPage(getDriver());
        cartPage.ClickCheckout();
        logger.info("Checkout page opened");

        // Place Order
        CheckOutPage checkOutPage = new CheckOutPage(getDriver());
        checkOutPage.ClickPlaceOrder();
        logger.info("Payment page opened");

        // Payment
        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.makePayment(
                nameOnCard,
                cardNumber,
                cvc,
                month,
                year);

        logger.info("Payment Successful");

        // Verify Order
        Assert.assertTrue(paymentPage.verifyOrderPlaced(),
                "Order is not placed successfully.");

        logger.info("Order placed successfully.");
        paymentPage.clickDownloadinvoice();
        logger.info("Download page opened");
        paymentPage.clickContinue();
    }
}