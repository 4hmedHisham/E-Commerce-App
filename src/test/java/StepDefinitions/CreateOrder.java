package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CreateOrder {
    Pages.CreateOrder createOrder = new Pages.CreateOrder(Hook.driver);

    @Then("user clicks cart icon")
    public void click_cart() throws InterruptedException {
        HomePage homepage = new HomePage(Hook.driver);
        homepage.ClickCartIcon();
        Thread.sleep(1000);
    }

    @And("user accepts tos")
    public void Accept_TOS(){createOrder.AcceptTermsOfService();}

    @And("user checks out")
    public void Checkout(){createOrder.ClickCheckout();}

    @And("user filll purchuse data")
    public void AddPurchuseData() throws InterruptedException {createOrder.AddPurchaseData();}
    @And("user clicks next until confirmation page")
    public void Clicknextnext() throws InterruptedException {createOrder.ClickNextNextNext();}

    @Then("user checks if order is done successfully")
    public void checkresponse(){
        String Response=createOrder.ReponseGet();
        Assert.assertEquals(Response,"Your order has been successfully processed!");
    }
}
