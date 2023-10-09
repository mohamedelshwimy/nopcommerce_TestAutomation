package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Locators
    private By loginNavBar = By.className("ico-login");
    private By logOutNavBar = By.className("ico-logout");
    private By emailField = By.id("Email");
    private By passField = By.id("Password");
    private By rememberCheck = By.id("RememberMe");
    private By forgotPass = By.xpath("//a[contains(.,'Forgot password?')]");
    private By loginButton = By.xpath("//button[contains(@class,'login-button')]");
    private By invalidCredentials = By.cssSelector(".validation-summary-errors");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Methods
    public void navToLogin(){

        driver.findElement(loginNavBar).click();
    }
    public void setEmailField (String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassField(String pass){
        driver.findElement(passField).sendKeys(pass);
    }
    public void setRememberCheck(){
        driver.findElement(rememberCheck).click();
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public ForgotPassword forgotPassCase(){
        return new ForgotPassword(driver);
    }
    public String getInvalidText(){
        Boolean display = driver.findElement(invalidCredentials).isDisplayed();
        if(display)
            return driver.findElement(invalidCredentials).getText();
        else
            return "Error in display msg";
    }
    public void clickLogout(){
        Boolean display = driver.findElement(logOutNavBar).isDisplayed();
        if (display)
            driver.findElement(logOutNavBar).click();
        else
            System.out.println("not logged in");
    }
    public AccountPage clickMyAccount(){
        return new AccountPage(driver);
    }

}
