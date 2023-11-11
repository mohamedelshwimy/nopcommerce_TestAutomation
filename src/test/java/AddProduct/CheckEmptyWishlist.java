package AddProduct;

import Base.BaseTests;
import Pages.WishlistPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckEmptyWishlist extends BaseTests {
    @Test
    public void testEmptyWishlist(){
        WishlistPage wishlistPage = homePage.goToWishlist();
        assertEquals(wishlistPage.getEmptyWishlistText(),"The wishlist is empty!","Wishlist not empty");
    }
}
