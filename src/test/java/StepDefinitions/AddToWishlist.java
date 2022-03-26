package StepDefinitions;

import Hooks.Hook;
import Pages.addidasShoesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AddToWishlist {
    addidasShoesPage addidas= new addidasShoesPage(Hook.driver);
    @And("adds item to wishlist")
    public void Click_Add_to_cart() throws InterruptedException {


        addidas.ClickAddToWishlist();
        Thread.sleep(2000);
    }
    @Then("Checks that item is added to wishlist")
    public void Check_wishlist_Added(){
        String Response2 = addidas.NotificationResposne();
        System.out.println("WISHLIST STRING ISsss "+ Response2);
        Assert.assertTrue(Response2.contains("The product has been added to your wishlist"));
    }
}
