package Login;

import Base.BaseTests;
import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test(dataProvider = "logInData")
    public void testLogin(String email, String pass){

        LoginPage loginPage = homePage.clickLogin_Nav();
        loginPage.navToLogin();
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.setRememberCheck();
        loginPage.clickLogin();
        //loginPage.clickLogout();
        assertEquals(loginPage.getInvalidText(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found",
                "Error in assertion");
    }
    @DataProvider
    public Object [] [] logInData ()
    {
        Object [][] data = new Object [3][2];
        data [0][0] = "TestNG@Framework.com";		data [0][1] = "TestNG1234";
        data [1][0] = "Joe@";			            data [1][1] = "DoeDoe34";
        data [2][0] = "Test@AutomationU.com";		data [2][1] = " ";

        return data;
    }


}
