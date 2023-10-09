package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public RegisterPage clickRegister_Nav(){
        return new RegisterPage(driver);
    }
    public LoginPage clickLogin_Nav(){
        return new LoginPage(driver);
    }

}
