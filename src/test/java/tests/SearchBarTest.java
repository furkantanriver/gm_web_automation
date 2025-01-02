package tests;

import org.testng.annotations.Test;
import com.getmobile.pages.SearchBar;


public class SearchBarTest extends BaseTest {
    @Test
    public void testSearchBarNavigation() {
        SearchBar searchBar = new SearchBar(driver);
        searchBar.selectPhoneController();
    }

}
