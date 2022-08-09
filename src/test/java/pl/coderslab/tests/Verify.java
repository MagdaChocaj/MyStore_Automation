package pl.coderslab.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.coderslab.main.pageobject.PageObject;

import java.util.ArrayList;
import java.util.List;

public class Verify extends PageObject {

    private List<String> priceList = new ArrayList<>();

    @FindBy(css = ".discount-percentage")
    WebElement discount;

    @FindBy(css = "#notifications > div > article")
    WebElement successInformation;

    @FindBy(css = "#notifications > div > article")
    WebElement deletionSuccessInfo;

    @FindBy(css = "#_desktop_user_info > div > a.account")
    WebElement userInfo;

    @FindBy(css = "#history-link")
    WebElement orderDetails;

    @FindBy(css = "#order-items > div > table > tbody > tr.font-weight-bold > td:nth-child(2)")
    WebElement price;

    @FindBy(css = "#content > table > tbody > tr:nth-child(1) > td.text-xs-right")
    WebElement secondPrice;

    @FindBy(css = "#content > table > tbody > tr:nth-child(1) > td:nth-child(5) > span")
    WebElement status;

    public Verify(WebDriver driver) {
        super(driver);
    }

    public String successInfo() {
        return successInformation.getText();
    }
    public String deletionInfo(){
        return deletionSuccessInfo.getText();
    }

    public Verify discount(){
        Assertions.assertEquals("SAVE 20%", discount.getText());
        return this;
    }

    public Verify orderStatus() {

        priceList.add(price.getText());

        userInfo.click();
        orderDetails.click();

        Assertions.assertEquals(priceList.get(0), secondPrice.getText());

        Assertions.assertTrue(status.getText().equals("Awaiting check payment"));

        return this;

    }
}
