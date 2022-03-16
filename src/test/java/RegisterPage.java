import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class RegisterPage {
    WebDriver driver;
    public  RegisterPage(WebDriver driver){
        this.driver=driver;
    }
    public void SelectMale(){driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"M\"]")).click();}
    public void FillFirstName(){ driver.findElement(By.id("FirstName")).sendKeys("Ahmed");}
    public void FillLastName(){ driver.findElement(By.id("LastName")).sendKeys("Hisham");}
    public void FillDayOfBirth(){
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dropdown.selectByValue("1");
    }
    public void FillMonthOfBirth(){
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dropdown.selectByValue("1");
    }
    public void FillYearOfBirth(){
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));
        dropdown.selectByValue("1997");
    }
    public String FillRandomMail(){

        Random rand = new Random();
        int randomnumber=rand.nextInt(1000);
        String Mail="ahmedHisham"+String.valueOf(randomnumber)+"@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(Mail);
        return Mail;
    }
    public String FillPassword(){
        String Password="123456";


        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        return Password;
    }
    public void FillCompany(){
        driver.findElement(By.id("Company")).sendKeys("UdacityTesting");
    }
    public void CLickRegister(){  driver.findElement(By.id("register-button")).click();}

    public void all(){
    }


}
