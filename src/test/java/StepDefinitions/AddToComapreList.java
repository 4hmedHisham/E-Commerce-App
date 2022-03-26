package StepDefinitions;

import Hooks.Hook;
import Pages.addidasShoesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AddToComapreList {
    addidasShoesPage addidas= new addidasShoesPage(Hook.driver);
    @And("adds item to comparelist")
    public void Click_Add_to_comparelist() throws InterruptedException {


        addidas.ClickAddToCompareLsit();
        Thread.sleep(2000);
    }
    @Then("Checks that item is added to comparelist")
    public void Check_comparelistt_Added(){
        String Response2 = addidas.NotificationResposne();
        Assert.assertTrue(Response2.contains("he product has been added to your product comparison"));
    }

}
