package SearchTests;

import Base.BaseTests;
import Pages.SearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidSearchProductTest extends BaseTests {
    //public String productName = "Build your own computer";
    @Test(dataProvider = "productNames")
    public void testSearchProduct(String productName){
        homePage.searchProduct(productName);
        SearchPage searchPage = homePage.clickSearchButton();
        searchPage.scrollToProducts();
        assertEquals(searchPage.getProductName(),productName,"Mismatch Search");
    }
    @DataProvider
    public Object [] productNames ()
    {
        Object [] data = new Object [6];
        data [0] = "Apple MacBook Pro 13-inch";
        data [1]= "Build your own computer";
        data [2]= "HTC One M8 Android L 5.0 Lollipop";
        data [3]= "Nokia Lumia 1020";
        data [4]= "Adobe Photoshop CS4";
        data [5]= "Night Visions";
        return data;
    }

}
