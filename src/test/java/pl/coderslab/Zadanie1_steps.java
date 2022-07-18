package pl.coderslab;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Zadanie1_steps {
    WebDriver driver;
    AddressForm addressForm;

    @Given("opened myStore webpage")
    public void beforeEach() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        this.driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user is signed in")
    public void userIsSignedIn() {
        addressForm = new AddressForm(driver);
        addressForm.login();
    }

    @And("address form is opened")
    public void userOpensAddressForm() {
        addressForm.openNewAddressForm();
    }

    @And("^address form is filled with (.*) (.*) (.*) (.*) (.*)$")
    public void userFillsAddressForm(String alias, String address, String city, String postalCode, String phoneNumber) {
        addressForm.createNewAddress(alias, address, city, postalCode, phoneNumber);

    }

    @And("save button is clicked")
    public void userClicksSaveButton() {
        addressForm.clickSaveButton();

    }

    @Then("{string} is displayed")
    public void userSees(String message) {
        Assertions.assertTrue(addressForm.getSuccessInfo().equals(message));

    }

    @And("address is deleted")
    public void userDeletesAddress() {
        addressForm.deleteAddress();

    }
    @And("user sees {string}")
    public void deletionMessage(String message){
        Assertions.assertTrue(addressForm.getDeletionInfo().equals(message));
    }
}


