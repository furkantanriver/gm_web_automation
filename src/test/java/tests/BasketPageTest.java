package tests;

import org.testng.annotations.Test;
import com.getmobile.pages.BasketPage;

public class BasketPageTest extends BaseTest {
    @Test
    public void testChangeBasket() {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.changeBasket();
    }
}
