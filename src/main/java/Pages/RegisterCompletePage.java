package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCompletePage {
    private WebDriver driver;
    private By registerComplete = By.cssSelector("div.result");
    public RegisterCompletePage(WebDriver driver){
        this.driver = driver;
    }
    public String registerCompleteText(){
        return driver.findElement(registerComplete).getText();
    }

}
