package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCompletePage {
    private WebDriver driver;
    private By registerComplete = By.cssSelector("div.result");
    private By continueButton = By.xpath("//a[contains(.,'Continue')]");
    public RegisterCompletePage(WebDriver driver){
        this.driver = driver;
    }
    public String registerCompleteText(){
        return driver.findElement(registerComplete).getText();
    }
    public HomePage clickContinueAfterRegister(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

}
