package tests;

import org.testng.annotations.Test;
import com.getmobile.pages.PhoneDetailPage;

public class PhoneDetailPageTest extends BaseTest {
    @Test
    public void testPhoneAddToBasket() {
        PhoneDetailPage phoneDetailPage = new PhoneDetailPage(driver);
        phoneDetailPage.addToCart();
    }

    @Test
    public void testPhoneDetails() {
        PhoneDetailPage phoneDetailPage = new PhoneDetailPage(driver);
        phoneDetailPage.checkPhoneNameDetails();
        phoneDetailPage.checkPriceDetails();
    }

    @Test
    public void testPhoneStockStatus() {
        PhoneDetailPage phoneDetailPage = new PhoneDetailPage(driver);
        phoneDetailPage.checkStockStatus();
    }


}
