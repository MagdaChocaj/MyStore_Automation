package pl.coderslab.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pl.coderslab.pageobject.PageObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static pl.coderslab.driver.DriverFactory.getEdgeDriver;

public class OrderPlacement extends PageObject {
    WebDriver driver = getEdgeDriver();

    public OrderPlacement(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#_desktop_logo > a")
    WebElement myStoreLogo;

    @FindBy(css = ".thumbnail-container > a[href*=\"rewrite=brown-bear-printed-sweater\"]")
    WebElement hummingbirdPrintedSweater;

    @FindBy(css = ".discount-percentage")
    WebElement discount;

    @FindBy(css = "#quantity_wanted")
    WebElement quantity;

    @FindBy(css = ".add > button")
    WebElement addToCartButton;

    @FindBy(css = ".cart-content-btn > a")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "[class*=\"cart-summary\"] .text-sm-center > a")
    WebElement checkoutButton;

    @FindBy(name = "confirm-addresses")
    WebElement confirmAddressButton;

    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliveryButton;

    @FindBy(css = "#payment-option-1")
    WebElement paymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsAndConditions;

    @FindBy(css = "#payment-confirmation > div.ps-shown-by-js > button")
    WebElement paymentConfirmation;

    public OrderPlacement addToCart() {

        myStoreLogo.click();
        hummingbirdPrintedSweater.click();

        Assertions.assertEquals("SAVE 20%", discount.getText());

        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByValue("2");

        quantity.clear();
        quantity.sendKeys("1");
        addToCartButton.click();

        return this;
    }

    public OrderPlacement placeAnOrder() {

        proceedToCheckoutButton.click();

        checkoutButton.click();

        confirmAddressButton.click();

        confirmDeliveryButton.click();

        paymentOption.click();

        termsAndConditions.click();

        paymentConfirmation.click();

        return this;
    }

    public OrderPlacement takeAScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File orderScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(orderScreenshot.toPath(), Paths.get("C:", "test evidence", "order_success.png"));
        } catch (IOException e) {
            System.out.println("Exception caught");
        }
        return this;
    }
}






