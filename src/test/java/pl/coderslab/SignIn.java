package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
    private WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(By.cssSelector("#_desktop_user_info > div > a")).click();

        WebElement emailInput = driver.findElement(By.cssSelector("#login-form > section > div:nth-child(2) > div.col-md-6 > input"));
        emailInput.sendKeys("randomEmail@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("#login-form > section > div:nth-child(3) > div.col-md-6 > div > input"));
        passwordInput.sendKeys("Mypassword123");

        driver.findElement(By.cssSelector("#submit-login")).click();
        //Assertions.assertEquals("Your account has been created.", "Your account has been created.");
    }
    public void createNewAddress(){
        driver.findElement(By.cssSelector("#address-link")).click();

        WebElement addressInput = driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(10) > div.col-md-6 > input"));
        WebElement postalCodeInput = driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(12) > div.col-md-6 > input"));
        WebElement cityInput = driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(13) > div.col-md-6 > input"));
        WebElement country = driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(14) > div.col-md-6 > select"));
        WebElement phoneNumberInput = driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(15) > div.col-md-6 > input"));
    }

}


