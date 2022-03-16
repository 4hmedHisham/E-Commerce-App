import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addidasShoesPage {
    WebDriver driver=null;
    public addidasShoesPage(WebDriver driver){
        this.driver=driver;
    }
    public void ClickAddToCart(){
        driver.findElement(By.id("add-to-cart-button-25")).click();
    }
    public String NotificationResposne(){
        return driver.findElement(By.xpath("//*[@class=\"bar-notification success\"]")).getText();
    }
    public void ClickAddToWishlist(){
        driver.findElement(By.id("add-to-wishlist-button-25")).click();
    }
    public void ClickAddToCompareLsit(){
        driver.findElement(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]")).click();
    }

}
