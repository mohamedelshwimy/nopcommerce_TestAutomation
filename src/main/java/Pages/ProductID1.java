package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductID1 {
    private WebDriver driver;
    public ProductID1(WebDriver driver) {
        this.driver = driver;
    }
    private By processorSelection = By.id("product_attribute_1");
    private By ramSelection = By.id("product_attribute_2");
    private By hddRadio = By.id("product_attribute_3_6");
    private By osRadio = By.id("product_attribute_4_9");
    private By addToCart = By.id("add-to-cart-button-1");

    public void selectProcessor(String option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(processorSelection));
        Select processor = new Select(driver.findElement(processorSelection));
        processor.selectByVisibleText(option);
    }
    public void selectRam(int index){
        Select ram = new Select(driver.findElement(ramSelection));
        ram.selectByIndex(index);
    }
    public void selectHDD(){
        driver.findElement(hddRadio).click();
    }
    public void selectOS(){
        driver.findElement(osRadio).click();
    }
    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }
}
