package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductPage extends BasePage {

    private WaitUtils ul;

    public CategoryProductPage(WebDriver driver) {
        super(driver);
        ul = new WaitUtils(driver);
    }

    // Heading
    private final By heading =
            By.cssSelector(".title.text-center");

    public String getHeading() {
        return ul.waitForVisibility(heading).getText();
    }

    // Product List
    private final By products =
            By.cssSelector(".features_items .product-image-wrapper");

    public int getProductCount() {
        return driver.findElements(products).size();
    }

    public boolean isProductsDisplayed() {
        return ul.waitForVisibility(products).isDisplayed();
    }
}