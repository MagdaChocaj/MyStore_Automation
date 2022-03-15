package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadanie1 {
    private WebDriver driver;

    public Zadanie1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#_desktop_user_info > div > a")
    WebElement userInfoButton;

    @FindBy(name = "#login-form > section > div:nth-child(2) > div.col-md-6 > input")
    WebElement emailInput;

    @FindBy(name = "#login-form > section > div:nth-child(3) > div.col-md-6 > div > input")
    WebElement passwordInput;

    @FindBy(css = "#submit-login")
    WebElement submitButton;

    @FindBy (id = "address-link")
    WebElement addAddressButton;

    @FindBy(name = "address1")
    WebElement addressInput ;

    @FindBy(name = "postcode")
    WebElement postalCodeInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "id_country")
    Select countrySelect;

    @FindBy(name = "phone")
    WebElement phoneNumberInput;

    @FindBy(name = "submitAddress")
    WebElement saveButton;

    @Given("Opened webpage: https://mystore-testlab.coderslab.pl/index.php")
    public void beforeEach() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        this.driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user is signed in")
    public void login() {
        userInfoButton.click();

        emailInput.sendKeys("randomEmail@gmail.com");

        passwordInput.sendKeys("Mypassword123");

        submitButton.click();
        //Assertions.assertEquals("Your account has been created.", "Your account has been created.");
    }
    @And("add first address button is clicked")
    public void addAddressButton(){
        addAddressButton.click();
    }
    @And("address form is filled with {word}, {word}, {word}, {word}")
    public void createNewAddress(String address, String city, String postalCode, String phoneNumber){
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        postalCodeInput.sendKeys(postalCode);
        countrySelect.selectByIndex(1);
        phoneNumberInput.sendKeys(phoneNumber);
    }
    @And("save button is clicked")
    public void clickSaveButton(){
        saveButton.click();
    }
    @Then("success info is displayed")
    public void userSees(){

    }

}


