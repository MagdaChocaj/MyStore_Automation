package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadanie1 {
    private WebDriver driver;

    @Given("opened myStore webpage")
    public void beforeEach() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        this.driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user is signed in")
    public void login() {
        WebElement signInButton = driver.findElement(By.cssSelector("#_desktop_user_info > div > a"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.cssSelector("#login-form > section > div:nth-child(2) > div.col-md-6 > input"));
        emailInput.sendKeys("randomEmail@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("#login-form > section > div:nth-child(3) > div.col-md-6 > div > input"));
        passwordInput.sendKeys("Mypassword123");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit-login"));
        submitButton.click();
        //Assertions.assertEquals("Your account has been created.", "Your account has been created.");
    }
    @And("add first address button is clicked")
    public void addAddressButton(){

        WebElement addAddressButton = driver.findElement(By.id("address-link"));
        addAddressButton.click();
    }
    @And("^address form is filled with (.*) (.*) (.*) (.*)$")
    public void createNewAddress(String address, String city, String postalCode, String phoneNumber){

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);

        WebElement postalCodeInput = driver.findElement(By.name("postcode"));
        postalCodeInput.sendKeys(postalCode);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);

        Select countrySelect = new Select(driver.findElement(By.name("id_country")));
        countrySelect.selectByIndex(1);

        WebElement phoneNumberInput = driver.findElement(By.name("phone"));
        phoneNumberInput.sendKeys(phoneNumber);

    }
    @And("save button is clicked")
    public void clickSaveButton(){
        WebElement saveButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        saveButton.click();
    }
    @Then("success info is displayed")
    public void userSees(){

    }

}


