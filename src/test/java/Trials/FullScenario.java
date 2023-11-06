package Trials;

import Base.BaseTests;
import Pages.LoginPage;
import Pages.ProductID1;
import Pages.RegisterCompletePage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FullScenario extends BaseTests {
    @Test
    public void fullPaymentScenario() throws InterruptedException {
        String email = "mohamed4@gmail.com";
        String pass = "12345678";
        //testSuccessfulRegister("Mohamed","Ahmed",email,pass);
        homePage.clickLogin_Nav();
        testSuccessfulLogin(email,pass);
        fillProductID1();
        }


    public void testSuccessfulRegister(String fname,String lname, String email,String pass) {
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.selectGender("male");
        registerPage.setFirstName(fname);
        registerPage.setLastName(lname);
        registerPage.selectDay("1");
        registerPage.selectMonth("November");
        registerPage.selectYear("1997");
        registerPage.setEmail(email);
        registerPage.setCompany("ITI");
        registerPage.newsCheckBox();
        registerPage.setPassField(pass);
        registerPage.setConfirmPass(pass);
        registerPage.clickRegisterButton();
        RegisterCompletePage registerCompletePage = registerPage.registerComplete();
        registerCompletePage.clickContinueAfterRegister();
        //homePage.clickLogout();
    }
    public void testSuccessfulLogin(String email, String pass){
        LoginPage loginPage = homePage.clickLogin_Nav();
        loginPage.navToLogin();
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.setRememberCheck();
        loginPage.clickLogin();
    }
    public void fillProductID1() throws InterruptedException {
        ProductID1 productID1 = homePage.clickProduct1Cart();
        String option = "2.2 GHz Intel Pentium Dual-Core E2200"; //"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"
        productID1.selectProcessor(option);//Added WebDriverWait to selectProcessor Method because of NoSuchElementException
        productID1.selectRam(2);
        productID1.selectHDD();
        productID1.selectOS();
        productID1.clickAddToCart();
    }
}
