package AddProduct;

import Base.BaseTests;
import Pages.CartPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckEmptyCart extends BaseTests {
    @Test
    public void checkEmptyCartText(){
        CartPage cartPage = homePage.goToEmptyCart();
        assertEquals(cartPage.getEmptyCartText(),"Your Shopping Cart is empty!","Cart is not empty");
    }
}
