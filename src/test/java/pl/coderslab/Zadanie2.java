package pl.coderslab;

import org.junit.jupiter.api.Test;
import pl.coderslab.pages.LoginPage;
import pl.coderslab.pages.OrderPlacement;
import pl.coderslab.pages.Verify;

public class Zadanie2 extends BaseTest {

    OrderPlacement newOrder = new OrderPlacement(driver);
    LoginPage login = new LoginPage(driver);
    Verify verify = new Verify(driver);

    @Test
    public void shouldPlaceAnOrder() {
        login.login();
        newOrder.addToCart()
                .placeAnOrder()
                .takeAScreenshot();
        verify.orderStatus();
    }
}
