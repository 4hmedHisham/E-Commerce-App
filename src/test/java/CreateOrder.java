import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateOrder {
    WebDriver driver=null;
    public CreateOrder(WebDriver driver){
        this.driver=driver;
    }
    public void  AcceptTermsOfService(){
        driver.findElement(By.id("termsofservice")).click();
    }
    public void ClickCheckout(){
        driver.findElement(By.id("checkout")).click();
    }
    public void AddPurchaseData() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        dropdown = new Select(driver.findElement(By.id("BillingNewAddress_StateProvinceId")));
        dropdown.selectByValue("1");


        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("CAIROOOO");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("ADRS1");
        driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("ADRS2");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12211");

        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("+211100");
        driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("+200011");
    }
    public void ClickNextNextNext () throws InterruptedException {
        driver.findElement(By.xpath("//button[@class=\"button-1 new-address-next-step-button\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]")).click();//button-1 shipping-method-next-step-button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]")).click();//button-1 payment-method-next-step-button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]")).click();//button-1 payment-info-next-step-button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]")).click();//button-1 confirm-order-next-step-button
        Thread.sleep(2000);
    }
    public String ReponseGet(){
        return driver.findElement(By.xpath("//div[@class=\"title\"]/strong")).getText();
    }
    public void all(){




//    driver.findElement(By.xpath("//BUTTON[@class=\"button-1 new-address-next-step-button\"]")).click();
//    Thread.sleep(500);


    }
}
