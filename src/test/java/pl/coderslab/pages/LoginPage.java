package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.coderslab.pageobject.PageObject;

public class LoginPage extends PageObject {

    @FindBy(css = ".user-info > a")
    WebElement signInButton;

    @FindBy(css = ".col-md-6 input[name=\"email\"]")
    WebElement emailInput;

    @FindBy(css = ".col-md-6 input[name=\"password\"]")
    WebElement passwordInput;

    @FindBy(css = "#submit-login")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {

        signInButton.click();

        emailInput.sendKeys("randomEmail@gmail.com");

        passwordInput.sendKeys("Mypassword123");

        submitButton.click();
    }
}
