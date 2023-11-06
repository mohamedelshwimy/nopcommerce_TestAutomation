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

    public Boolean checkVisibilityOfCartTable(){
        return driver.findElement(cartTable).isDisplayed();
    }



}
