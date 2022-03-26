package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ChangingCurrencies {
    String response=null;
    @When("user Changes currency to euro at homepage")
    public void ChangeToEuro() throws InterruptedException {
        HomePage homePage = new HomePage(Hook.driver);
         response =homePage.ChangeCurrencyToEuro();
        Thread.sleep(500);

    }
    @Then("Check Currency Changed to euro")
    public void Euro_Assert(){
        Assert.assertEquals(response,"Euro");

    }
    @When("user Changes currency to dollar at homepage")
    public void ChangeToDollar() throws InterruptedException {
        HomePage homePage = new HomePage(Hook.driver);
        response=homePage.ChangeCurrencyToDollar();
        Thread.sleep(500);

    }
    @Then("Check Currency Changed to dollar")
    public void DollarAssert(){
        Assert.assertEquals(response,"US Dollar");
    }
}
