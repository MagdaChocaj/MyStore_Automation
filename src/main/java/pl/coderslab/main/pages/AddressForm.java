package pl.coderslab.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pl.coderslab.main.driver.DriverFactory;
import pl.coderslab.main.pageobject.PageObject;

public class AddressForm extends PageObject {

    WebDriver driver = DriverFactory.getEdgeDriver();

    @FindBy(id = "addresses-link")
    WebElement addressesButton;

    @FindBy(css = "#content > div.addresses-footer > a")
    WebElement createNewAddressButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    WebElement aliasInput;

    @FindBy(xpath ="/html/body/main/section/div/div/section/section/div/div/form/section/div[6]/div[1]/input")
    WebElement addressInput;

    @FindBy (name = "postcode")
    WebElement postalCodeInput;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/form/section/div[8]/div[1]/input")
    WebElement cityInput;

    @FindBy(name = "phone")
    WebElement phoneNumberInput;

    @FindBy (css = "#content > div > div > form > footer > button")
    WebElement saveButton;

    @FindBy (xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]")
    WebElement deleteButton;

    public AddressForm(WebDriver driver) {
        super(driver);
    }

    public void openNewAddressForm() {

        addressesButton.click();
        createNewAddressButton.click();
    }

    public void createNewAddress(String alias, String address, String city, String postalCode, String phoneNumber) {

        aliasInput.sendKeys(alias);

        addressInput.sendKeys(address);

        postalCodeInput.sendKeys(postalCode);

        cityInput.sendKeys(city);

        Select countrySelect = new Select(driver.findElement(By.name("id_country")));
        countrySelect.selectByIndex(1);

        phoneNumberInput.sendKeys(phoneNumber);

    }

    public void clickSaveButton() {

        try {
            saveButton.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Exception caught");

        }

    }

    public void deleteAddress() {
        deleteButton.click();
    }

}
