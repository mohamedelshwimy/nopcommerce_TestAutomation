package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppleMacBookPage {
    private WebDriver driver;
    public AppleMacBookPage(WebDriver driver){
        this.driver = driver;
    }
    //Locators
    private By productName = By.className("product-name");

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
