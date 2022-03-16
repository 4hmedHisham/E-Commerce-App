import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
