package HomePageTests;

import Base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class NavigationBarElementsTests extends BaseTests {
    @Test
    public void testNavBarElements(){
        homePage.clickSearchButton();


    }
    @Test
    public void testDropDown(){
        homePage.selectCurrency("Euro"); //US Dollar - Euro

    }
}
