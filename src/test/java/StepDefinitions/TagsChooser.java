package StepDefinitions;

import Hooks.Hook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TagsChooser {
    
    public void fun() throws InterruptedException {



        //Products tagged with 'nice'   ,cool


        Hook.driver.findElement(By.xpath("//a[contains(text(),\"cool\")]")).click();
        int count2 = Hook.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();



    }

    @When("user navigate to all tags")
    public void gotoalltags() throws InterruptedException {
        Hook.driver.navigate().to("https://demo.nopcommerce.com/producttag/all");
        Thread.sleep(600);
    }
    @And("^User Clicks \"(.*)\" tag$")
    public void clickTag(String tag) throws InterruptedException {
        Hook.driver.findElement(By.xpath("//a[contains(text(),\""+tag+"\")]")).click();
        Thread.sleep(700);


    }
    @Then("^User should directed to \"(.*)\" tag$")
    public void checktag(String tag){
        String Text=Hook.driver.findElement(By.xpath("//div[@class= \"page-title\"]/h1")).getText();
        Assert.assertEquals(Text,"Products tagged with '"+tag+"'");
    }

    @Then("User Closes Chrome")
    public void closedriver() throws InterruptedException {
        Thread.sleep(600);
        Hook.driver.close();
        Hook.driver.quit();
        System.out.println("Email is "+Hook.Mail);
    }


}
