package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject2 {
    private WebDriver driver;

    public PageObject2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#_desktop_logo > a > img")
    WebElement myStoreLogo;

    @FindBy(css = "#content > section > div > article:nth-child(2) > div > div.product-description > h3 > a")
    WebElement hummingbirdPrintedSweater;

    Select size = new Select(driver.findElement(By.id("group_1")));
    size.select

    @FindBy(css = "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")
    WebElement addToCartButton;

    @FindBy(css = "#quantity_wanted");
    WebElement quantity;

    @FindBy("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    WebElement checkout;

    @FindBy(css = "#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")
    WebElement checkout;


}
