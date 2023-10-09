package Login;

import Pages.AccountPage;
import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountTests extends LoginTests{
    @Test(dataProvider = "logInData")
    public void testAccountChanges(String email,String pass){
        LoginPage loginPage = homePage.clickLogin_Nav();
        loginPage.navToLogin();
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.setRememberCheck();
        loginPage.clickLogin();
        AccountPage accountPage = loginPage.clickMyAccount();
        accountPage.clickMyAcc();
        accountPage.clickCustomerInfo();
        accountPage.clickAddresses();
        accountPage.clickDownloadableProducts();
        accountPage.clickOrders();

        loginPage.clickLogout();
        //assertEquals(loginPage.getInvalidText(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found","Error in assertion");

    }

}
