package StepDefinitions;

import Hooks.Hook;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ChangeCategories {
    String txt;
    @When("^user clicks on \"(.*)\" button$")
    public void ChooseCategory(String Category){
        HomePage homepage = new HomePage(Hook.driver);

        if(Category.equals("Computers")){
             txt =homepage.GotoComputersPage();
        }
        else if(Category.equals("Electronics")){
             txt =homepage.GoToElectronicsPage();
        }
        else{
             txt="Empty";
        }
    }

    @Then("^Check that category is \"(.*)\"$")
    public void CheckCategory(String Category){
        Assert.assertEquals(txt,Category);
    }
}
