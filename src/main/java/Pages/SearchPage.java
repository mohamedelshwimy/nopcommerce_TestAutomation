package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    //Locators
    private By productName =
            By.xpath("//h2[@class='product-title']");
    private By noSuchProduct = By.className("no-result");
    private By sortSelection = By.id("products-orderby");
    private By firstProductPrice = By.xpath("//div[@class='item-box'][1]//span[@class=('price actual-price')]");
    private By secondProductPrice = By.xpath("//div[@class='item-box'][2]//span[@class=('price actual-price')]");
    private By firstProductName = By.xpath("//div[@class='item-box'][1]//h2//a");
    private By secondProductName = By.xpath("//div[@class='item-box'][2]//h2//a");

    //Methods
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public void scrollToProducts(){
        WebElement productsDiv = driver.findElement(productName);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, productsDiv);
    }
    public String getNoSuchProductMsg(){
        return driver.findElement(noSuchProduct).getText();
    }
    public String getAlertMsg(){
        return driver.switchTo().alert().getText();
    }
    public void closeAlert(){
        driver.switchTo().alert().accept();
    }
    public void setSortSelection(int index){
        Select sort = new Select(driver.findElement(sortSelection));
        sort.selectByIndex(index);
    }
    public String getPriceOfFirstProduct(){
        return driver.findElement(firstProductPrice).getText();
    }
    public String getPriceOfSecondProduct(){
        return driver.findElement(secondProductPrice).getText();
    }
    public String getNameOfFirstProduct(){
        return driver.findElement(firstProductName).getText();
    }
    public String getNameOfSecondProduct(){
        return driver.findElement(secondProductName).getText();
    }
}
