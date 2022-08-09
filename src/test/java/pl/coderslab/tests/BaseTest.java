package pl.coderslab.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pl.coderslab.main.driver.DriverFactory.getEdgeDriver;
import static pl.coderslab.main.driver.DriverFactory.getWebDriverWait;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static final String BASE_URL = "https://mystore-testlab.coderslab.pl/index.php";

    @BeforeAll
    public static void setup() {
        driver = getEdgeDriver();
        driver.get(BASE_URL);
        wait = getWebDriverWait();
    }

    @AfterAll
    public static void cleanUp(){
        driver.close();
    }
}
