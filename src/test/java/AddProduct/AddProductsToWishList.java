package AddProduct;

import Base.BaseTests;
import Pages.ProductID18;
import Pages.ProductID4;
import Pages.WishlistPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddProductsToWishList extends BaseTests {
    WishlistPage wishlistPage;
    @Test
    public void testAddingProductToWishlist(){
        homePage.addProduct18toWishlist();
        assertEquals(homePage.getWishlistNotificationText(),
                "The product has been added to your wishlist",
                "Error adding item to wishlist");
        homePage.closeWishlistNotification();
        assertEquals(homePage.getWishlistQty(),"(1)","Wrong Quantity");
        wishlistPage = homePage.goToWishlist();
        assertTrue(wishlistPage.checkWishlistTableVisibility(),"Wishlist Table not visible");
        assertEquals(wishlistPage.getProductCode(),"M8_HTC_5L","Wrong Product Code");
    }
}
