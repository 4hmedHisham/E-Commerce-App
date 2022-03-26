package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    public static WebDriver driver = null;
    public static String Mail = "Empty";
    public static String Password = "Empty";
    public static void Start_Driver(){
        String prj_path= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",prj_path+"\\src\\main\\resources\\chromedriver.exe");

        driver=new ChromeDriver();
        //driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
}
