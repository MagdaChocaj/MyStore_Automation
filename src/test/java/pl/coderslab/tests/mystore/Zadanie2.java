package pl.coderslab.tests.mystore;

import org.junit.jupiter.api.Test;
import pl.coderslab.main.pages.LoginPage;
import pl.coderslab.main.pages.OrderPlacement;
import pl.coderslab.tests.Verify;
import pl.coderslab.tests.BaseTest;

public class Zadanie2 extends BaseTest {

    OrderPlacement newOrder = new OrderPlacement(driver);
    LoginPage login = new LoginPage(driver);
    Verify verify = new Verify(driver);

    @Test
    public void shouldPlaceAnOrder() {
        login.login();
        newOrder.pickAProduct();
        verify.discount();
        newOrder.addToCart()
                .placeAnOrder()
                .takeAScreenshot();
        verify.orderStatus();
    }
}
