package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver){this.driver = driver;}
    //Locators
    private By customerInfo = By.xpath("//li[contains(@class,'customer-info')]//a");
    private By addresses = By.xpath("//li[contains(@class,'customer-addresses')]//a");
    private By orders = By.xpath("//li[contains(@class,'customer-orders')]//a");
    private By downloadableProducts = By.xpath("//li[contains(@class,'downloadable-products')]//a");

    //Methods
    public void clickCustomerInfo(){
        driver.findElement(customerInfo).click();
    }
    public void clickAddresses(){
        driver.findElement(addresses).click();
    }
    public void clickOrders(){
        driver.findElement(orders).click();
    }
    public void clickDownloadableProducts(){
        driver.findElement(downloadableProducts).click();
    }
    public void clickMyAcc(){
        driver.findElement(By.className("ico-account")).click();
    }
}
