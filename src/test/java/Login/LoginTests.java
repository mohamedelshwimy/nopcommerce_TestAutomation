package Login;

import Base.BaseTests;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    public void testLogin(){
        LoginPage loginPage = homePage.clickLogin_Nav();
        loginPage.setEmailField("");
        loginPage.setPassField("");
        loginPage.setRememberCheck();
        loginPage.clickLogin();
    }
}
