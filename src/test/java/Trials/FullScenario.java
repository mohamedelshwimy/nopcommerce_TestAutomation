package Trials;

import Base.BaseTests;
import Pages.RegisterCompletePage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

public class FullScenario extends BaseTests {
    @Test
    public void fullPaymentScenario(){
        testSuccessfulRegister("Mohamed","Ahmed","mohamed1@gmail.com","12345678");
        homePage.
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
    }
}
