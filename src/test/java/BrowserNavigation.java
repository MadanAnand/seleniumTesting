import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class BrowserNavigation {
    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    static public String  titles= "";
    public static void browserBackButtonTest()
    {

        System.setProperty(TestDataGenerator.setPropDriver, TestDataGenerator.setDriverPath);
        driver = new ChromeDriver();

        driver.navigate().to(TestDataGenerator.googleUrl);
        System.out.println("Title of the page:: " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys(TestDataGenerator.googleKeepUrl);
        driver.findElement(By.name("btnG")).click();
        //       driver.navigate().to(TestDataGenerator.googleKeepUrl);
        System.out.println("Title of the page:: " + driver.getTitle());
        driver.navigate().back();
        System.out.println("Title of the page:: " + driver.getTitle());


    }
}
