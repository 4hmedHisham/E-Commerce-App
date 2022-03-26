package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SubCategory {
    String txt="Empty";
    @When("user Hover on appearal Then Choose Shoes")
    public void choose_apperal_shoes(){
        HomePage homepage = new HomePage(Hook.driver);

         txt = homepage.GoToSubCategory();
    }

    @Then("Shoes is selected")
    public void Shoes_Selected() throws InterruptedException {
        Assert.assertEquals(txt,"Shoes");
        Thread.sleep(300);
    }
}
