import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver=null;
    public  HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void ClickRegister(){ driver.findElement(By.className("ico-register")).click();}
    public void ClickLogin(){driver.findElement(By.xpath("//*[contains(@class,\"ico-login\")]")).click(); }
    public void ClickLogout(){ driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();}
}
