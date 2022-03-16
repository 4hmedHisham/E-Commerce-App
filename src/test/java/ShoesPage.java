import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShoesPage {
    WebDriver driver=null;
    public ShoesPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean FilterByRedAndCheck() throws InterruptedException {

        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("adidas Consortium Campus 80s Running Shoes")).click();
        Thread.sleep(200);
        return  driver.findElement(By.id("product_attribute_10_25")).isSelected();
    }
    public void GoToitemPage() throws InterruptedException {
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        WebElement we =driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a"))).click().build().perform();
        Thread.sleep(1500);
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("adidas Consortium Campus 80s Running Shoes")).click();
        Thread.sleep(200);
        System.out.println(driver.findElement(By.id("product_attribute_10_25")).isSelected());


        Select dropdown2 = new Select(driver.findElement(By.id("product_attribute_9")));
        dropdown2.selectByValue("21");
    }
}
