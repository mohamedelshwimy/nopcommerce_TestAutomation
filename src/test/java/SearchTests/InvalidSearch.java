package SearchTests;

import Base.BaseTests;
import Pages.SearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidSearch extends BaseTests {
    String noMatchesFound = "No products were found that matched your criteria.";
    String invalidSearchData = "123456";
    String emptySearch = "";
    String specialCharSearch = "@pple";
    private SearchPage searchPage;
    @Test
    public void testInvalidSearchProduct(){
        homePage.searchProduct(invalidSearchData);
        searchPage = homePage.clickSearchButton();
        assertEquals(searchPage.getNoSuchProductMsg(),noMatchesFound,"Mismatch Search");
    }
    @Test
    public void searchEmptyField(){
        homePage.searchProduct(emptySearch);
        searchPage = homePage.clickSearchButton();
        assertEquals(searchPage.getAlertMsg(),"Please enter some search keyword","alert msg mismatch");
        searchPage.closeAlert();
    }
    @Test
    public void searchWithSpecialCharacters(){
        homePage.searchProduct(specialCharSearch);
        searchPage = homePage.clickSearchButton();
        assertEquals(searchPage.getNoSuchProductMsg(),noMatchesFound,"Mismatch Search");
    }

}
