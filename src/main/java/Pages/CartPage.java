package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage{
    private WebDriver driver;
    private WebElement caption;
    public CartPage(WebDriver driver){this.driver = driver;}
    public CartPage(WebElement caption){
        this.caption=caption;
    }


}
