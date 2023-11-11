package EndToEndScenarios;

import Base.BaseTests;
import Pages.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FullScenario extends BaseTests {
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ProductID1 productID1;
    public CheckoutCompletePage checkoutComplete;
    private String firstName = "Mohamed";
    private String lastName = "Ahmed";
    private String email = "mohamed4@gmail.com";
    private String pass = "12345678";
    @Test
    public void fullUserPurchaseScenario() throws InterruptedException {
        testSuccessfulRegister(firstName,lastName,email,pass);
        homePage.clickLogin_Nav();
        testSuccessfulLogin(email,pass);
        assertEquals(homePage.checkLoginSuccessful(),true,"Not Logged In");
        fillProductID1();
        assertEquals(cartPage.checkVisibilityOfCartTable(),true,"table not visible");
        cartPage.acceptTermsOfService();
        checkoutPage = cartPage.clickCheckOut();
        fillCheckout();
        checkoutComplete = checkoutPage.clickConfirmationContinueBtn();
        assertEquals(checkoutComplete.checkConfirmationMsg(),
                "Your order has been successfully processed!",
                "Msg Not matched");
        checkoutComplete.clickLastContinueBtn();
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
        productID1 = homePage.clickProduct1Cart();
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
    public void fillCheckout() throws InterruptedException {
        checkoutPage.clickDeleteSavedAddress();
        checkoutPage.setFName(firstName);
        checkoutPage.setLName(lastName);
        checkoutPage.setEmail(email);
        checkoutPage.setCountryField(1);
        checkoutPage.setStateField(4);
        checkoutPage.setCityField("Alaska");
        checkoutPage.setAddress1Field("Alaska");
        checkoutPage.setPostalCodeField("123456");
        checkoutPage.setPhoneNumberField("123456");
        checkoutPage.clickAddressContinueBtn();
        checkoutPage.clickShippingContinueBtn();
        checkoutPage.choosePaymentMethod();
        checkoutPage.clickPaymentMethodContinueBtn();
        checkoutPage.selectCreditType("Visa");
        checkoutPage.setCardHolder(firstName);
        checkoutPage.setCardNumber("4073865265477");
        checkoutPage.selectExpireYear("2024");
        checkoutPage.setCardCode("123");
        checkoutPage.clickPaymentInfoContinueBtn();
        checkoutPage.clickConfirmationContinueBtn();
    }
}
