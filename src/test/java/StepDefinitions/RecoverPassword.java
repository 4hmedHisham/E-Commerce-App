package StepDefinitions;

import Hooks.Hook;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;



public class RecoverPassword {
    

    @And("Press Logout")
    public void Logout(){Hook.driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();}

    @And("PressLogin")
    public void login(){Hook.driver.findElement(By.xpath("//*[contains(@class,\"ico-login\")]")).click();}

    @And("user chooses  password recovery")
    public void RecoverPasswordCLick() throws InterruptedException {
        Hook.driver.findElement(By.xpath("//*[contains(@href,\"/passwordrecovery\")]")).click();
        Thread.sleep(400);
    }

    @And("TypeMail")
    public void TypeMail(){Hook.driver.findElement(By.id("Email")).sendKeys(Hook.Mail);}


    @And("user presses recover password")
    public void PressRecover() throws InterruptedException {
        Hook.driver.findElement(By.xpath("//button[@type=\"submit\"][text() = 'Recover']")).click();
        Thread.sleep(700);}


    @And("User should be able to recover passowrd")
    public void CheckIfRecoverSuccessful(){
        String Response =Hook.driver.findElement(By.xpath("//*[contains(@class,\"content\")]")).getText();
        Assert.assertEquals(Response,"Email with instructions has been sent to you.");
    }
}
