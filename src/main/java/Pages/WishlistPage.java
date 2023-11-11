package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    private WebDriver driver;
    public WishlistPage(WebDriver driver){
        this.driver = driver;
    }
    private By emptyWishlist = By.className("no-data");
    private By productCode = By.className("sku-number");
    private By wishlistTable = By.cssSelector("table.cart");
    public String getEmptyWishlistText(){
        return driver.findElement(emptyWishlist).getText();
    }
    public boolean checkWishlistTableVisibility(){
        return driver.findElement(wishlistTable).isDisplayed();
    }
    public String getProductCode(){
        return driver.findElement(productCode).getText();
    }
}
