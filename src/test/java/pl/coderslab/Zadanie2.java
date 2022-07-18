package pl.coderslab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Zadanie2 {
    WebDriver driver;
    AddressForm addressForm;
    OrderPlacement newOrder;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        this.driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Test
    public void shouldPlaceAnOrder() {
        addressForm = new AddressForm(driver);
        newOrder = new OrderPlacement(driver);
        addressForm.login();
        newOrder.addToCart();
        newOrder.placeAnOrder();
        newOrder.takeAScreenshot();
        newOrder.orderStatus();
    }
}
