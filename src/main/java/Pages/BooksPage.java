package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BooksPage {
    private WebDriver driver;
    public WebElement cart() {
        return driver.findElement(By.className("cart-label"));
    }

    public BooksPage(WebDriver driver){
        this.driver = driver;
    }
    private By booksNavBar = By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Books')]");
    private By firstBookAddToCart = By.xpath
            ("//div[@class='item-box'][1]//button[contains(@class,'product-box-add-to-cart-button')]");
    private By firstBookAddToCompare = By.xpath
            ("//div[@class='item-box'][1]//button[contains(@class,'product-box-add-to-compare-list-button')]");
    private By firstBookAddToWishList = By.xpath
            ("//div[@class='item-box'][1]//button[contains(@class,'add-to-wishlist-button')]");

    private By sortBy = By.id("products-orderby");
    private By viewGrid = By.cssSelector("a[title='Grid']");
    private By viewList = By.cssSelector("a[title='List']");
    private By flyoutCartButton = By.xpath("//div[@id='flyout-cart']//button");

    public void clickBooks(){
        driver.findElement(booksNavBar).click();
    }
    private Select findDropDownElement(){
        return new Select(driver.findElement(sortBy));
    }
    public void setSortBy(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public void setViewGrid(){
        driver.findElement(viewGrid).click();
    }
    public void setViewList(){
        driver.findElement(viewList).click();
    }

    public void addFirstBookToCart(){
        driver.findElement(firstBookAddToCart).click();
    }
    public void addFirstBookToCompare(){
        driver.findElement(firstBookAddToCompare).click();
    }
    public void addFirstBookToWish(){
        driver.findElement(firstBookAddToWishList).click();
    }

    public void hoverOverCartFlyOut(){
        WebElement cart = driver.findElement(By.className("cart-label"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cart).perform();
        driver.findElement(flyoutCartButton).click();
    }
    public CartPage openCart(){
        return new CartPage(driver);
    }
}
