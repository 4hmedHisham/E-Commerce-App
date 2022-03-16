import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}
