package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductID4 {
    private WebDriver driver;
    public ProductID4(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By productQnty= By.id("product_enteredQuantity_4");
    private By addToCart = By.id("add-to-cart-button-4");
    private By addToWishlist = By.id("add-to-wishlist-button-4");
    private By addToCompare = By.xpath("//div[@class='compare-products']/button");
    private By successNotification = By.xpath("//p[@class='content']");
    private By closeNotification = By.xpath("//span[@class='close']");
    private By goToCart = By.xpath("//span[@class='cart-label']");

    //Methods
    public void setProductQnty(String qnty){
        driver.findElement(productQnty).clear();
        driver.findElement(productQnty).sendKeys(qnty);
    }
    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    public String getNotificationText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(successNotification));
        return driver.findElement(successNotification).getText();
    }
    public void closeNotification(){
        driver.findElement(closeNotification).click();
    }
    public CartPage navToCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(goToCart).click();
        return new CartPage(driver);
    }
    public String getProductCompareSuccessText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(successNotification));
        return driver.findElement(successNotification).getText();
    }
    public String getProductAddedToWishlistText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(successNotification));
        return driver.findElement(successNotification).getText();
    }


}
