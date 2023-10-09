package Register;

import Base.BaseTests;
import Pages.RegisterCompletePage;
import Pages.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RegisterTests extends BaseTests {
    @Test(dataProvider = "logInData")
    public void testRegister(String email,String pass) {
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.selectGender("male");
        registerPage.setFirstName("Mohamed");
        registerPage.setLastName("Ahmed");
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
    @DataProvider
    public Object [] [] logInData ()
    {
        Object [][] data = new Object [3][2];

        data [0][0] = "TestNG@Framework.com";		data [0][1] = "TestNG1234";
        data [1][0] = "Joe@Doe.com";			    data [1][1] = "DoeDoe34";
        data [2][0] = "Test@AutomationU.com";		data [2][1] = "TAU1234";

        return data;
    }

    @Test
    public void testRegisterEmptyFields(){
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.clickRegisterButton();
    }

}
