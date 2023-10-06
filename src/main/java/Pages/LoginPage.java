package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){this.driver = driver;}
    private By login_homepage = By.className("ico-login");
    private By emailField = By.id("Email");
    private By passField = By.id("Password");
    private By rememberCheck = By.id("RememberMe");
    private By forgotPass = By.xpath("//a[contains(.,'Forgot password?')]");
    private By loginButton = By.className("button-1 login-button");
    public void clickLoginHomePage(){
        driver.findElement(loginButton).click();
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

}
