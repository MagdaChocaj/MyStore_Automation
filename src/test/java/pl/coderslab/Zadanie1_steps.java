package pl.coderslab;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AddressForm;
import pl.coderslab.pages.LoginPage;
import pl.coderslab.pages.Verify;
import static pl.coderslab.driver.DriverFactory.getEdgeDriver;

public class Zadanie1_steps extends BaseTest {

    WebDriver driver = getEdgeDriver();
    AddressForm addressForm = new AddressForm(driver);
    Verify verify = new Verify(driver);
    LoginPage login = new LoginPage(driver);

    @Given("opened myStore webpage")
    public void beforeEach() {
        setup();
    }

    @When("user is signed in")
    public void userIsSignedIn() {
        login.login();
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
        Assertions.assertTrue(verify.successInfo().equals(message));

    }

    @And("address is deleted")
    public void userDeletesAddress() {
        addressForm.deleteAddress();

    }
    @And("user sees {string}")
    public void deletionMessage(String message){
        Assertions.assertTrue(verify.deletionInfo().equals(message));
    }
}


