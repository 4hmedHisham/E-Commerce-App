import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driverInner=null;

    public HomePage(WebDriver driver) {
        driverInner=driver;
    }

    public void ClickRegister(){
        driverInner.findElement(By.className("ico-register")).click();
    }
}
