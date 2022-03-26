package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps {

    @And("user enters valid login data")
    public void valid_login() throws InterruptedException {
        HomePage homepage=new HomePage(Hook.driver);
        homepage.ClickLogin();
        Thread.sleep(700);
        System.out.println("MAIL IS : "+Hook.Mail);
        System.out.println("Password is  IS : "+Hook.Password);
        LoginPage loginpage= new LoginPage(Hook.driver);
        loginpage.fillusername(Hook.Mail);
        loginpage.fillpassword(Hook.Password);
        loginpage.clickLogin();

        Thread.sleep(1500);




    }
    @Then("uer login sucessfully")
    public void login_success(){
        Hook.driver.navigate().to("https://demo.nopcommerce.com/");//Should be deted exist in startup code
        Assert.assertTrue(Hook.driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).isDisplayed());
    }
}
