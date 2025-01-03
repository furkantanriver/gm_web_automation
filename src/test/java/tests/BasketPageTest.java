package tests;

import com.getmobile.pages.PhoneDetailPage;
import org.testng.annotations.Test;
import com.getmobile.pages.BasketPage;

public class BasketPageTest extends BaseTest {

    @Test
    public void testChangeBasket() {
        PhoneDetailPage phoneDetailPage = new PhoneDetailPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        phoneDetailPage.addToCart();
        basketPage.redirectBasketPage();
        basketPage.changeBasket();
    }
}
