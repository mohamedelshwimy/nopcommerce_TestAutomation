package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage{
    private WebDriver driver;
    public CartPage(WebDriver driver){this.driver = driver;}

    //Locators
    private By cartTable = By.cssSelector(".cart");
    private By termsOfService = By.id("termsofservice");
    private By checkoutBtn = By.id("checkout");

    public Boolean checkVisibilityOfCartTable(){
        return driver.findElement(cartTable).isDisplayed();
    }
    public void acceptTermsOfService(){
        driver.findElement(termsOfService).click();
    }
    public CheckoutPage clickCheckOut(){

        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }



}
