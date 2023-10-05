package Register;

import Base.BaseTests;
import Pages.RegisterCompletePage;
import Pages.RegisterPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class RegisterTests extends BaseTests {
    @Test
    public void testRegister(){
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.selectGender("male");
        registerPage.setFirstName("Mohamed");
        registerPage.setLastName("Ahmed");
        registerPage.selectDay("1");
        registerPage.selectMonth("November");
        registerPage.selectYear("1997");
        registerPage.setEmail("12345@gmail.com");
        registerPage.setCompany("ITI");
        registerPage.newsCheckBox();
        registerPage.setPassField("12345678");
        registerPage.setConfirmPass("12345678");
        registerPage.clickRegisterButton();
    }
    @Test
    public void testRegisterEmptyFields(){
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.clickRegisterButton();
    }
}
