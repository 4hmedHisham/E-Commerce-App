package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegestrationSteps {
    


    @Given("user open chrome borwser")
    public void open_chrome(){
        Hook.Start_Driver();
        //Thread.sleep(3000);
    }
    @And("user navigate to homepage")
    public void navigate_to_homepage() throws InterruptedException {
        Hook.driver.navigate().to("https://demo.nopcommerce.com/");
        //Hook.driver.manage().window().maximize();
        Thread.sleep(1500);
    }

    @When("user Clicks Register and  enters valid data")
    public void enter_valid_data(){
        HomePage hompage= new HomePage(Hook.driver);
        hompage.ClickRegister();
        RegisterPage registerpage = new RegisterPage(Hook.driver);
        registerpage.SelectMale();
        registerpage.FillFirstName();
        registerpage.FillLastName();
        registerpage.FillDayOfBirth();
        registerpage.FillMonthOfBirth();
        registerpage.FillYearOfBirth();
        registerpage.FillCompany();
        Hook.Mail=registerpage.FillRandomMail();
        Hook.Password=registerpage.FillPassword();
        registerpage.CLickRegister();
    }
    @Then("User Register Sucessfully")
    public void check_regestration_process() throws InterruptedException {
        String AssertionText = Hook.driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(AssertionText,"Your registration completed");
        //System.out.println("AssedrtionTExt is " +AssertionText);
        Hook.driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();
        Thread.sleep(2000);
    }
}
