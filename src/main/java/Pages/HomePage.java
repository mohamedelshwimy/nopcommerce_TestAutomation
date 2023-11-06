package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;
    private By currencyDropDown = By.id("customerCurrency");
    private By logout_nav = By.className("ico-logout");
    private By productID1 = By.xpath("//div[@data-productid=('1')]");
    private By addProduct1ToCart = By.xpath("//div[@data-productid=('1')]//button[contains(text(),'Add to cart')]");


    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public RegisterPage clickRegister_Nav(){
        return new RegisterPage(driver);
    }
    public LoginPage clickLogin_Nav(){return new LoginPage(driver);}
    public BooksPage goToBooks(){
        return new BooksPage(driver);
    }
    public HomePage clickLogout(){
        driver.findElement(logout_nav).click();
        return new HomePage(driver);
    }

    public void selectCurrency(String option){
        Select dropdownElement = new Select(driver.findElement(currencyDropDown));
        dropdownElement.selectByVisibleText(option);
    }

    public void scrollToProducts(){
        WebElement productsDiv = driver.findElement(productID1);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, productsDiv);
    }

    public ProductID1 clickProduct1Cart(){
        scrollToProducts();
        driver.findElement(addProduct1ToCart).click();
        return new ProductID1(driver);
    }

}
