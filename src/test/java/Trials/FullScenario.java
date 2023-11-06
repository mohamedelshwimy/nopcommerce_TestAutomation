package Trials;

import Base.BaseTests;
import Pages.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FullScenario extends BaseTests {
    public static CartPage cartPage;
    @Test
    public void fullUserPurchaseScenario(){
        String email = "mohamed4@gmail.com";
        String pass = "12345678";
        //testSuccessfulRegister("Mohamed","Ahmed",email,pass);
        homePage.clickLogin_Nav();
        testSuccessfulLogin(email,pass);
        fillProductID1();
        assertEquals(cartPage.checkVisibilityOfCartTable(),true,"table not visible");
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
    public void fillProductID1(){
        ProductID1 productID1 = homePage.clickProduct1Cart();
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
    }

}
