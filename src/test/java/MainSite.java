import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainSite {
    int randomnumber=-1;
    String Mail="EMPTY";
    String Password="Empty";


    WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

    }



    @Test
    public void T01_Register() throws InterruptedException {
        //CommandText.SendEnglish(CommandText.Commands.Click_Register_on_HomePage,driver);
        HomePage hompage= new HomePage(driver);
        hompage.ClickRegister();
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.SelectMale();
        registerpage.FillFirstName();
        registerpage.FillLastName();
        registerpage.FillDayOfBirth();
        registerpage.FillMonthOfBirth();
        registerpage.FillYearOfBirth();
        registerpage.FillCompany();
        Mail=registerpage.FillRandomMail();
        Password=registerpage.FillPassword();
        registerpage.CLickRegister();

        String AssertionText = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(AssertionText,"Your registration completed");
        //System.out.println("AssedrtionTExt is " +AssertionText);
        driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void T02_Login() throws InterruptedException {
        HomePage homepage=new HomePage(driver);
        homepage.ClickLogin();
        Thread.sleep(700);
        System.out.println("MAIL IS : "+Mail);
        System.out.println("Password is  IS : "+Password);
        LoginPage loginpage= new LoginPage(driver);
        loginpage.fillusername(Mail);
        loginpage.fillpassword(Password);
        loginpage.clickLogin();

        Thread.sleep(1500);



        driver.navigate().to("https://demo.nopcommerce.com/");//Should be deted exist in startup code
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).isDisplayed());
//        driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();
    }


    @Test
    public void T03_SwitchBetweenCurrencies() throws InterruptedException {
                driver.findElement(By.id("customerCurrency"));

        Select dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        WebElement option =dropdown.getFirstSelectedOption();

        dropdown.selectByVisibleText("Euro");
        dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        option =dropdown.getFirstSelectedOption();
        System.out.println("OPTION AFter Euro "+option.getText().toLowerCase());
        Thread.sleep(500);
        dropdown = new Select(driver.findElement(By.id("customerCurrency")));

//        System.out.println(driver.findElement(By.id("customerCurrency")).getText());
//        System.out.println(dropdown.getOptions());
//        System.out.println(dropdown.getFirstSelectedOption().getText());

        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Euro");

        dropdown = new Select(driver.findElement(By.id("customerCurrency")));
        dropdown.selectByVisibleText("US Dollar");
        dropdown = new Select(driver.findElement(By.id("customerCurrency")));
         option =dropdown.getFirstSelectedOption();
        System.out.println("OPTION After US DOLLAR "+option.getText());
        Thread.sleep(500);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"US Dollar");
    }
    @Test
    public void T04_User_Choose_Differnt_category() throws InterruptedException {
        //driver.navigate().to("https://demo.nopcommerce.com/computers");
        driver.findElement(By.xpath("//a[@href=\"/computers\"]")).click();
        String txt=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        System.out.println(txt);
        Assert.assertEquals(txt,"Computers");
        NavigateToUrl();

        driver.findElement(By.xpath("//a[@href=\"/electronics\"]")).click();
        txt=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        System.out.println(txt);
        Assert.assertEquals(txt,"Electronics");
        NavigateToUrl();
        Thread.sleep(1500);

    }
    @Test
    public void T05_GetSubCategory() throws InterruptedException {
         Actions action = new Actions(driver);
         WebElement we =driver.findElement(By.xpath("//a[contains(text(), 'Apparel')]"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Shoes')]"))).click().build().perform();
        String txt=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        System.out.println(txt);
        Assert.assertEquals(txt,"Shoes");
        Thread.sleep(300);
    }
    @Test
    public void T06_FilterByColor() throws InterruptedException {
                //driver.findElement(By.xpath("//a[contains(text(), 'Shoes')]")).click();

        Actions action = new Actions(driver);
        WebElement we =driver.findElement(By.xpath("//a[contains(text(), 'Apparel')]"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Shoes')]"))).click().build().perform();
        Thread.sleep(1500);
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("adidas Consortium Campus 80s Running Shoes")).click();
        Thread.sleep(200);
        System.out.println(driver.findElement(By.id("product_attribute_10_25")).isSelected());
        Assert.assertEquals(driver.findElement(By.id("product_attribute_10_25")).isSelected(),true);//Checks the color
        Thread.sleep(600);

    }
    public void GoToitemPage() throws InterruptedException {
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        WebElement we =driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a"))).click().build().perform();
        Thread.sleep(1500);
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("adidas Consortium Campus 80s Running Shoes")).click();
        Thread.sleep(200);
        System.out.println(driver.findElement(By.id("product_attribute_10_25")).isSelected());


        Select dropdown2 = new Select(driver.findElement(By.id("product_attribute_9")));
        dropdown2.selectByValue("21");
    }
    @Test
    public void T07_AddToCart() throws InterruptedException {


        GoToitemPage();

        //The product has been added to your
        driver.findElement(By.id("add-to-cart-button-25")).click();
        Thread.sleep(2000);

        String Response2 =driver.findElement(By.xpath("//*[@class=\"bar-notification success\"]")).getText();
        Assert.assertTrue(Response2.contains("he product has been added to your shopping cart"));
    }
    @Test
    public void T08_AddToWishList() throws InterruptedException {

        GoToitemPage();


        //The product has been added to your
        driver.findElement(By.id("add-to-wishlist-button-25")).click();
        Thread.sleep(3000);
        String Response2 =driver.findElement(By.xpath("//*[@class=\"bar-notification success\"]")).getText();
        Assert.assertTrue(Response2.contains("he product has been added to your wishlist"));

    }
    @Test
    public void T09_AddToCompareList() throws InterruptedException {
        GoToitemPage();
        driver.findElement(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]")).click();
        Thread.sleep(2000);
        String Response2 =driver.findElement(By.xpath("//*[@class=\"bar-notification success\"]")).getText();
        System.out.println("LAST RESPONSE IS "+Response2);
        Assert.assertTrue(Response2.contains("he product has been added to your product comparison"));

    }

    @Test
    public void T10_CreateSucessfulOrder() throws InterruptedException {
        driver.findElement(By.id("topcartlink")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(700);
//        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Ahmed");
//        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Hisham");
//        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Checkoutmail@gmail.com");
//        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Company2");

        Select dropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        dropdown = new Select(driver.findElement(By.id("BillingNewAddress_StateProvinceId")));
        dropdown.selectByValue("1");


        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("CAIROOOO");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("ADRS1");
        driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("ADRS2");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12211");

        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("+211100");
        driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("+200011");

//    driver.findElement(By.xpath("//BUTTON[@class=\"button-1 new-address-next-step-button\"]")).click();
//    Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class=\"button-1 new-address-next-step-button\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]")).click();//button-1 shipping-method-next-step-button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]")).click();//button-1 payment-method-next-step-button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]")).click();//button-1 payment-info-next-step-button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]")).click();//button-1 confirm-order-next-step-button
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"title\"]/strong")).getText(),"Your order has been successfully processed!");




    }

    @Test
    public void T11_SearchItems() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Nokia");
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class=\"button-1 search-box-button\"]")).click();//how to verify?
        Thread.sleep(500);

        int count = driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();
        Assert.assertTrue(count > 0);
        for (int x = 0; x < count ; x++) {

            Assert.assertTrue(driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText().toLowerCase().contains("nokia"));
        }

    }

    @Test
    public void T12_RecoverPassowrd() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(@class,'ico-logout')]")).click();
        driver.findElement(By.xpath("//*[contains(@class,\"ico-login\")]")).click();

        driver.findElement(By.xpath("//*[contains(@href,\"/passwordrecovery\")]")).click();
        Thread.sleep(400);

        driver.findElement(By.id("Email")).sendKeys(Mail);
        driver.findElement(By.xpath("//button[@type=\"submit\"][text() = 'Recover']")).click();
        Thread.sleep(700);
        String Response =driver.findElement(By.xpath("//*[contains(@class,\"content\")]")).getText();
        Assert.assertEquals(Response,"Email with instructions has been sent to you.");

    }

    @Test
    public void T13_CheckDifferentTags() throws InterruptedException {
        //
        driver.navigate().to("https://demo.nopcommerce.com/producttag/all");
        Thread.sleep(600);
        driver.findElement(By.xpath("//a[contains(text(),\"nice\")]")).click();

        int count1 = driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();

        Thread.sleep(700);
        driver.findElement(By.xpath("//a[contains(text(),\"cool\")]")).click();
        int count2 = driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();

        Assert.assertTrue(count1!=count2);
    }



    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
        String prj_path= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",prj_path+"\\src\\main\\resources\\chromedriver.exe");

        driver=new ChromeDriver();
        //driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        //Thread.sleep(3000);
    }
    @BeforeMethod
    public void NavigateToUrl() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //driver.manage().window().maximize();
        Thread.sleep(1500);
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @AfterTest
    public void CloseDriver() throws InterruptedException {

        Thread.sleep(600);
        driver.close();
        driver.quit();
        System.out.println("Email is "+Mail);
    }
}
