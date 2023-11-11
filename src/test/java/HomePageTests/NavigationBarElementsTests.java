package HomePageTests;
import Base.BaseTests;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.WishlistPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class NavigationBarElementsTests extends BaseTests {
    LoginPage loginPage;
    RegisterPage registerPage;
    @Test
    public void testLoginBtnNavBar(){
        loginPage = homePage.clickLogin_Nav();
        loginPage.navToLogin();
        assertEquals(loginPage.getWelcomeSignInText(),
                "Welcome, Please Sign In!",
                "SignIn Welcome msg wrong");
    }
    @Test
    public void testRegisterBtnNavBar(){
        registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        assertEquals(registerPage.getRegisterText(),"Register","Wrong register msg");
    }
    @Test
    public void testCartBtnNavBar(){
        CartPage cartPage = homePage.goToEmptyCart();
        assertEquals(cartPage.getEmptyCartText(),"Your Shopping Cart is empty!","Cart is not empty");
    }
    @Test
    public void testDropDown(){
        homePage.selectCurrency("Euro"); //US Dollar - Euro
    }
    @Test
    public void testWishlistBtnNavBar(){
        WishlistPage wishlistPage = homePage.goToWishlist();
        assertEquals(wishlistPage.getEmptyWishlistText(),"The wishlist is empty!","Wishlist not empty");
    }
}
