package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class HomePage {

    WebDriver driver=null;
    public  HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void ClickRegister(){ driver.findElement(By.className("ico-register")).click();}
    public void ClickLogin(){driver.findElement(By.xpath("//*[contains(@class,\"ico-login\")]")).click(); }
    public void ClickLogout(){ driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();}
    public String ChangeCurrencyToEuro(){         Select dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        WebElement option =dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("Euro");
        dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        option =dropdown.getFirstSelectedOption();
        return  dropdown.getFirstSelectedOption().getText();

    }
    public  String ChangeCurrencyToDollar(){
        Select dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        WebElement option =dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("US Dollar");
        dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        option =dropdown.getFirstSelectedOption();
        //.out.println("OPTION After US DOLLAR "+);
        return option.getText();
    }
    public String GotoComputersPage(){
        driver.findElement(By.xpath("//a[@href=\"/computers\"]")).click();
        String txt=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        return txt;
    }
    public String  GoToElectronicsPage(){
        driver.findElement(By.xpath("//a[@href=\"/electronics\"]")).click();
        String txt=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        System.out.println(txt);
        return txt;
    }
    public String GoToSubCategory(){

        Actions action = new Actions(driver);
        WebElement we =driver.findElement(By.xpath("//a[contains(text(), 'Apparel')]"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Shoes')]"))).click().build().perform();
        String txt=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        return txt;

    }
    public void  ClickCartIcon(){
        driver.findElement(By.id("topcartlink")).click();
    }
}
