package Trials;

import Base.BaseTests;
import org.testng.annotations.Test;

public class DropDown extends BaseTests {
    @Test
    public void testDropDown(){
        homePage.selectCurrency("Euro"); //US Dollar - Euro
    }

}
