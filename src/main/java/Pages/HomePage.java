package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;
    private By currencyDropDown = By.id("customerCurrency");
    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public RegisterPage clickRegister_Nav(){
        return new RegisterPage(driver);
    }
    public LoginPage clickLogin_Nav(){
        return new LoginPage(driver);
    }
    public BooksPage goToBooks(){
        return new BooksPage(driver);
    }
    public void selectCurrency(String option){
        Select dropdownElement = new Select(driver.findElement(currencyDropDown));
        dropdownElement.selectByVisibleText(option);
    }

}
