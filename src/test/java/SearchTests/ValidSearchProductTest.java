package SearchTests;

import Base.BaseTests;
import Pages.SearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ValidSearchProductTest extends BaseTests {
    //public String productName = "Build your own computer";
    private SearchPage searchPage;
    @Test(dataProvider = "productNames")
    public void testSearchProduct(String productName){
        homePage.searchProduct(productName);
        SearchPage searchPage = homePage.clickSearchButton();
        searchPage.scrollToProducts();
        assertEquals(searchPage.getProductName(),productName,"Mismatch Search");
    }
    @Test
    public void sortByPriceAfterSearch() throws ParseException {
        homePage.searchProduct("notebook");
        searchPage = homePage.clickSearchButton();
        searchPage.setSortSelection(4);
        //Handle $ sign in price
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number firstProduct = format.parse(searchPage.getPriceOfFirstProduct());
        Number secondProduct = format.parse(searchPage.getPriceOfSecondProduct());
        boolean result = firstProduct.intValue() > secondProduct.intValue();
        assertTrue(result,"Not Sorted By Price");
    }
    @Test
    public void sortByAlphabeticalOrderSearch(){
        homePage.searchProduct("notebook");
        searchPage = homePage.clickSearchButton();
        searchPage.setSortSelection(1);
        String firstProduct = searchPage.getNameOfFirstProduct();
        String secondProduct = searchPage.getNameOfSecondProduct();
        int comparisonResult  = firstProduct.compareTo(secondProduct);
        boolean result;
        if (comparisonResult < 0) {
            //first is smaller
            result = true;
        }
        else if (comparisonResult > 0) {
            //second is larger
            result = false;
        }
        else {
            //first is equal to second
            result = false;
        }
        assertTrue(result,"Not Sorted Alphabetically");
    }

    @DataProvider
    public Object [] productNames () {
        Object [] data = new Object [6];
        data [0]= "Apple MacBook Pro 13-inch";
        data [1]= "Build your own computer";
        data [2]= "HTC One M8 Android L 5.0 Lollipop";
        data [3]= "Nokia Lumia 1020";
        data [4]= "Adobe Photoshop CS4";
        data [5]= "Night Visions";
        return data;
    }
}
