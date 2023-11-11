package Login;

import Pages.AccountPage;
import Pages.LoginPage;
import org.mohamedelshwimy.ReadData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountTests extends LoginTests{


    @Test(dataProvider = "ReadVariant")
    public void testAccountChanges(String fname,String lname, String email,String pass){
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
    }


}
