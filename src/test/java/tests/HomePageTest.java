package tests;

import org.testng.annotations.Test;
import com.getmobile.pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageElements() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
    }

    @Test
    public void testAllSliders() {
        HomePage homePage = new HomePage(driver);
        homePage.areAllBannersDisplayed();
    }
}
