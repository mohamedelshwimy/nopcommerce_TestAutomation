package Register;

import Base.BaseTests;
import Pages.RegisterCompletePage;
import Pages.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RegisterTests extends BaseTests {
    @Test(dataProvider = "ReadVariant")
    public void testRegister(String fname,String lname, String email,String pass) {
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
    }

    @Test
    public void testRegisterEmptyFields(){
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.clickRegisterButton();
    }


}
