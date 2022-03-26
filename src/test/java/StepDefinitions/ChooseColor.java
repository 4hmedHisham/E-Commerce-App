package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import Pages.ShoesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ChooseColor {

    @When("Choose color red")
    public void Choose_Red(){
        HomePage homepage = new HomePage(Hook.driver);
        homepage.GoToSubCategory();
        ShoesPage shoespage = new ShoesPage(Hook.driver);
    }
    @Then("Click an item and check if the checked color is red")
    public void Check_Chosen_Color_Is_Red() throws InterruptedException {
        ShoesPage shoespage = new ShoesPage(Hook.driver);
        Assert.assertEquals(shoespage.FilterByRedAndCheck(),true);//Checks the color
        Thread.sleep(600);
    }
}
