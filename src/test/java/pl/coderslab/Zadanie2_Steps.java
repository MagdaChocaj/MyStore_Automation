package pl.coderslab;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Zadanie2_Steps {
    WebDriver driver;
    PageObject pageObject;
    PageObject2 pageObject2;

    @Given("myStore webpage")
    public void beforeEach() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        this.driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user is logged in")
    public void userIsSignedIn() {
        pageObject = new PageObject(driver);
        pageObject2 = new PageObject2(driver);
        pageObject.login();
    }
}
