package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    private WebDriverWait wait;
    //Locators
    private By deleteSavedAddress = By.id("delete-billing-address-button");
    //AddressDetails
    private By fName = By.id("BillingNewAddress_FirstName");
    private By LName = By.id("BillingNewAddress_LastName");
    private By emailField = By.id("BillingNewAddress_Email");
    private By countryField = By.id("BillingNewAddress_CountryId");
    private By stateField = By.id("BillingNewAddress_StateProvinceId");
    private By stateFieldChildLocator =
            By.xpath("By.xpath(//select[@id='BillingNewAddress_StateProvinceId']//option[@value='53'])");
    private By cityField = By.id("BillingNewAddress_City");
    private By address1Field = By.id("BillingNewAddress_Address1");
    private By postalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private By addressContinueBtn = By.xpath("//button[@onclick='Billing.save()']");

    //ShippingDetails
    private By groundShippingMethod = By.id("shippingoption_0");
    private By shippingContinueBtn = By.xpath("//button[@onclick=('ShippingMethod.save()')]");

    //PaymentMethod
    private By paymentMethodCC = By.id("paymentmethod_1");
    private By paymentMethodContinueBtn = By.xpath("//button[contains(@onclick,'PaymentMethod.save()')]");

    //CreditCardDetails
    private By creditCardType = By.id("CreditCardType");
    private By cardHolder = By.id("CardholderName");
    private By cardNumber = By.id("CardNumber");
    private By expireYear = By.id("ExpireYear");
    private By cardCode = By.id("CardCode");
    private By paymentInfoContinueBtn = By.xpath("//button[@onclick='PaymentInfo.save()']");

    //ConfirmPurchase
    private By cartTableOfContent = By.xpath("//button[@onclick='ConfirmOrder.save()']");
    //private By confirmationMsg = By.xpath("//strong[contains(.,'Your order has been successfully processed!')]");
    private By confirmationContinueBtn = By.xpath("//button[@onclick='ConfirmOrder.save()']");
    //private By lastContinueBtn = By.xpath("//button[contains(.,'Continue')]");

    //Methods
    public void clickDeleteSavedAddress(){
        //wait.until(ExpectedConditions.elementToBeClickable(deleteSavedAddress));
        if(driver.findElement(deleteSavedAddress).isDisplayed()){
            driver.findElement(deleteSavedAddress).click();
        }
    }
    //AddressDetails
    public void setFName(String firstName) {
        wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(fName));
        driver.findElement(fName).clear();
        driver.findElement(fName).sendKeys(firstName);
    }
    public void setLName(String lastName){
        driver.findElement(LName).clear();
        driver.findElement(LName).sendKeys(lastName);
    }
    public void setEmail(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCountryField(int countryIndex){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(countryField));
        Select chooseCountry = new Select(driver.findElement(countryField));
        chooseCountry.selectByIndex(countryIndex);
    }
    public void setStateField(int stateIndex) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(stateField,stateFieldChildLocator));
        Select chooseState = new Select(driver.findElement(stateField));
        chooseState.selectByIndex(stateIndex);
    }
    public void setCityField(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void setAddress1Field (String address){
        driver.findElement(address1Field).sendKeys(address);
    }
    public void setPostalCodeField(String postal){
        driver.findElement(postalCodeField).sendKeys(postal);
    }
    public void setPhoneNumberField(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void clickAddressContinueBtn(){
        driver.findElement(addressContinueBtn).click();
    }

    //ShippingDetails
    public void setGroundShippingMethod(){
        driver.findElement(groundShippingMethod).click();
    }
    public void clickShippingContinueBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinueBtn));
        driver.findElement(shippingContinueBtn).click();
    }
    //PaymentMethod
    public void choosePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodCC));
        driver.findElement(paymentMethodCC).click();
    }
    public void clickPaymentMethodContinueBtn(){
        driver.findElement(paymentMethodContinueBtn).click();
    }

    //CreditCardDetails
    public void selectCreditType(String option) {
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(creditCardType));
        Select select = new Select(driver.findElement(creditCardType));
        select.selectByVisibleText(option);
    }
    public void setCardHolder(String cardHolderName){
        driver.findElement(cardHolder).sendKeys(cardHolderName);
    }
    public void setCardNumber(String cardNum){
        driver.findElement(cardNumber).sendKeys(cardNum);
    }
    public void selectExpireYear(String year){
        Select select = new Select(driver.findElement(expireYear));
        select.selectByVisibleText(year);
    }
    public void setCardCode(String code){
        driver.findElement(cardCode).sendKeys(code);
    }
    public void clickPaymentInfoContinueBtn(){
        driver.findElement(paymentInfoContinueBtn).click();
    }

    //ConfirmPurchase
    public Boolean checkCartTable (){
        return driver.findElement(cartTableOfContent).isDisplayed();
    }
    public CheckoutCompletePage clickConfirmationContinueBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationContinueBtn));
        driver.findElement(confirmationContinueBtn).click();
        return new CheckoutCompletePage(driver);
    }

}
