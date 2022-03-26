package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public  WebDriver driver=null;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public  void fillusername(String username){

        driver.findElement(By.id("Email")).sendKeys(username);
    }

    public void fillpassword(String password){
        driver.findElement(By.id("Password")).sendKeys(password);
    }
    public  void clickLogin(){
        driver.findElement(By.xpath("//button[@type=\"submit\"][@class=\"button-1 login-button\"]")).click();

    }
}
