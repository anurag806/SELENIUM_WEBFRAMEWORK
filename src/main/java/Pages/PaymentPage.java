package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private final WaitUtils ul;

    public PaymentPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }

    // Locators
    private final By nameOnCard = By.name("name_on_card");
    private final By cardNumber = By.name("card_number");
    private final By cvc = By.name("cvc");
    private final By expiryMonth = By.name("expiry_month");
    private final By expiryYear = By.name("expiry_year");
    private final By payAndConfirmOrder = By.id("submit");

    // Success Message
    private final By orderPlaced =
            By.xpath("//b[text()='Order Placed!']");

    // Continue Button
    private final By continueButton =
            By.xpath("//a[text()='Continue']");

    // Enter Name on Card
    public void enterNameOnCard(String name) {
        type(ul.waitForVisibility(nameOnCard), name);
    }

    // Enter Card Number
    public void enterCardNumber(String card) {
        type(ul.waitForVisibility(cardNumber), card);
    }

    // Enter CVC
    public void enterCVC(String cvcCode) {
        type(ul.waitForVisibility(cvc), cvcCode);
    }

    // Enter Expiry Month
    public void enterExpiryMonth(String month) {
        type(ul.waitForVisibility(expiryMonth), month);
    }

    // Enter Expiry Year
    public void enterExpiryYear(String year) {
        type(ul.waitForVisibility(expiryYear), year);
    }

    // Click Pay & Confirm Order
    public void clickPayAndConfirmOrder() {
        safeClick(payAndConfirmOrder);
    }

    // Complete Payment
    public void makePayment(String name,
                            String card,
                            String cvcCode,
                            String month,
                            String year) {

        enterNameOnCard(name);
        enterCardNumber(card);
        enterCVC(cvcCode);
        enterExpiryMonth(month);
        enterExpiryYear(year);

        clickPayAndConfirmOrder();
    }

    // Verify Order Placed
    public boolean verifyOrderPlaced() {
        return ul.waitForVisibility(orderPlaced).isDisplayed();
    }

    // Click Continue
    public void clickContinue() {
        safeClick(continueButton);
    }
    //click Download invoice
    private final By downloadInvoice =
            By.cssSelector("a.btn.btn-default.check_out");
    public void clickDownloadinvoice() {
        ul.waitForClickable(downloadInvoice);
        safeClick(downloadInvoice);
    }
}