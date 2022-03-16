import org.openqa.selenium.WebDriver;

public class CommandText {
    enum Commands{
        Click_Register_on_HomePage,
    }
    public static void SendEnglish(Commands com, WebDriver driver){
        if (com==Commands.Click_Register_on_HomePage){
            HomePage page1 = new HomePage(driver);
            page1.ClickRegister();
        }
    }
}
