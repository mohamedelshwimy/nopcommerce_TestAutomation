package AddProduct;

import Base.BaseTests;
import Pages.CartPage;
import Pages.ProductID1;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddProductToCart extends BaseTests {
    ProductID1 productID1;
    CartPage cartPage;
    @Test
    public void addProductID1ToCartThenRemove() throws InterruptedException {
        productID1 = homePage.clickProduct1Cart();
        String option = "2.2 GHz Intel Pentium Dual-Core E2200"; //"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"
        productID1.selectProcessor(option); //Added WebDriverWait to selectProcessor Method because of NoSuchElementException
        productID1.selectRam(1);
        productID1.selectHDD();
        productID1.selectOS();
        productID1.clickAddToCart();
        assertEquals(productID1.getNotificationText(),
                "The product has been added to your shopping cart",
                "msg not matched");
        productID1.closeNotification();
        cartPage = productID1.navToCart();
        assertTrue(cartPage.checkVisibilityOfCartTable(),"Cart is empty");
        assertEquals(cartPage.getProductNameFromTable(),"COMP_CUST","More than 1 item added to cart");
        cartPage.removeItemFromCart(1);
        assertEquals(cartPage.getEmptyCartText(),"Your Shopping Cart is empty!","CartTable still visible");
    }

}
