package StepDefinitions;

import Hooks.Hook;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchItems {


    @When("searches for nokia")
    public void SearchItems() throws InterruptedException {
        Hook.driver.findElement(By.id("small-searchterms")).sendKeys("Nokia");
        Hook.driver.findElement(By.xpath("//button[@class=\"button-1 search-box-button\"]")).click();//how to verify?
        Thread.sleep(500);
    }
    @Then("the user should find items that have \"nokia\" in its name")
    public void CheckSearchSucessfull(){
        int count = Hook.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();
        Assert.assertTrue(count > 0);
        for (int x = 0; x < count ; x++) {

            Assert.assertTrue(Hook.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText().toLowerCase().contains("nokia"));
        }
    }
}
