
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

//        driver.findElement(By.id("customerCurrency"));

        HomePage homePage = new HomePage(driver);
        String response =homePage.ChangeCurrencyToEuro();
        Thread.sleep(500);
        Assert.assertEquals(response,"Euro");
        response=homePage.ChangeCurrencyToDollar();
        Thread.sleep(500);
        Assert.assertEquals(response,"US Dollar");
    }
    @Test
    public void T04_User_Choose_Differnt_category() throws InterruptedException {
        //driver.navigate().to("https://demo.nopcommerce.com/computers");
        HomePage homepage = new HomePage(driver);

        String txt =homepage.GotoComputersPage();
        Assert.assertEquals(txt,"Computers");
        NavigateToUrl();

        txt=homepage.GoToElectronicsPage();
        Assert.assertEquals(txt,"Electronics");
        NavigateToUrl();
        Thread.sleep(1500);

    }
    @Test
    public void T05_GetSubCategory() throws InterruptedException {
        HomePage homepage = new HomePage(driver);

        String txt = homepage.GoToSubCategory();
        Assert.assertEquals(txt,"Shoes");
        Thread.sleep(300);
    }
    @Test
    public void T06_FilterByColor() throws InterruptedException {
                //driver.findElement(By.xpath("//a[contains(text(), 'Shoes')]")).click();
        HomePage homepage = new HomePage(driver);
        homepage.GoToSubCategory();
        ShoesPage shoespage = new ShoesPage(driver);
        Assert.assertEquals(shoespage.FilterByRedAndCheck(),true);//Checks the color
        Thread.sleep(600);

    }

    @Test
    public void T07_AddToCart() throws InterruptedException {
        ShoesPage shoespage = new ShoesPage(driver);
        shoespage.GoToitemPage();

        //The product has been added to your
        addidasShoesPage addidas = new addidasShoesPage(driver);
        addidas.ClickAddToCart();
        Thread.sleep(2000);

        String Response2 = addidas.NotificationResposne();
        Assert.assertTrue(Response2.contains("he product has been added to your shopping cart"));
    }
    @Test
    public void T08_AddToWishList() throws InterruptedException {

        ShoesPage shoespage = new ShoesPage(driver);
        shoespage.GoToitemPage();


        //The product has been added to your
        addidasShoesPage addidas = new addidasShoesPage(driver);
        addidas.ClickAddToWishlist();
        Thread.sleep(2000);

        String Response2 =addidas.NotificationResposne();
        Assert.assertTrue(Response2.contains("he product has been added to your wishlist"));

    }
    @Test
    public void T09_AddToCompareList() throws InterruptedException {
        //GoToitemPage();
        ShoesPage shoespage = new ShoesPage(driver);
        shoespage.GoToitemPage();

        addidasShoesPage addidas = new addidasShoesPage(driver);
        addidas.ClickAddToCompareLsit();

        Thread.sleep(2000);
        String Response2 =addidas.NotificationResposne();
        System.out.println("LAST RESPONSE IS "+Response2);
        Assert.assertTrue(Response2.contains("he product has been added to your product comparison"));

    }

    @Test
    public void T10_CreateSucessfulOrder() throws InterruptedException {
       HomePage homepage = new HomePage(driver);
       homepage.ClickCartIcon();
        Thread.sleep(1000);
        CreateOrder createOrder = new CreateOrder(driver);
        createOrder.AcceptTermsOfService();
        createOrder.ClickCheckout();
        createOrder.AddPurchaseData();
        createOrder.ClickNextNextNext();
        String Response=createOrder.ReponseGet();
        Assert.assertEquals(Response,"Your order has been successfully processed!");




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
