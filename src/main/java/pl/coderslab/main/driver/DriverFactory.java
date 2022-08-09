package pl.coderslab.main.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory(){

    }

    public static WebDriver getEdgeDriver() {

        if(driver == null){
            System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static WebDriverWait getWebDriverWait() {

        if (wait == null) {
            wait = new WebDriverWait(getEdgeDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"col-md-7 right-nav\"]")));
        }
        return wait;
    }

}
