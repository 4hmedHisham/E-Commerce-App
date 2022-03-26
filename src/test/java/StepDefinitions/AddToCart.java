package StepDefinitions;

import Hooks.Hook;
import Pages.ShoesPage;
import Pages.addidasShoesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddToCart {
    addidasShoesPage addidas = new addidasShoesPage(Hook.driver);

    @When("user navigate to Sepcific item")
    public void Navigate_to_item() throws InterruptedException {
        ShoesPage shoespage = new ShoesPage(Hook.driver);
        shoespage.GoToitemPage();
        addidasShoesPage addidas = new addidasShoesPage(Hook.driver);
    }
    @And("adds item to cart")
    public void Click_Add_to_cart() throws InterruptedException {

        addidas.ClickAddToCart();
        Thread.sleep(2000);


    }
    @Then("Checks that item is added to cart")
    public void Check_cart_Added(){
        String Response2 =addidas.NotificationResposne();
        System.out.println("Cart STRING IS "+ Response2);
        Assert.assertTrue(Response2.contains("The product has been added to your shopping cart"));
    }
}
