import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import sun.font.TrueTypeFont;

public class Main {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Test
    public void mainTest() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/wEll/IdeaProjects/test-master/chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 300);

        boolean result;
        try {
            int x=1;

        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            //  driver.close();
        }
    }

    @Test
    public  void googleKeepTest() {
        TestControlPage t= new TestControlPage();
        t.googleKeepTest();
        t.driverClose();


    }

    @Test
    public void uploadTest() throws Exception {

        TestControlPage t= new TestControlPage();
        t.uploadTest();
        t.driverClose();


    }
    @Test
    public void fluentWaitTest()
    {

        TestControlPage t= new TestControlPage();
        t.fluentWaitTest();
        t.driverClose();
    }
    @Test
    public void downloadTest()
    {
        TestControlPage t= new TestControlPage();
        t.downloadTest();
        t.driverClose();

    }

    @Test
    public void multiStaticPageTest() throws InterruptedException
    {

        TestControlPage t= new TestControlPage();
        t.multiStaticPageTest();
        t.driverClose();

    }

    @Test
    public void CookieTest()
    {   TestControlPage t= new TestControlPage();
        t.cookieSet();
        t.driverClose();

    }

    @Test
    public void RandomStaticTest()
    {
        TestControlPage t= new TestControlPage();

        t.RandomStaticTest();
        t.driverClose();

    }

    @Test
    public void hoverTest()
    {
        ActionBot.hoverTest();
    }

    @Test
    public void dragAndDropTest()
    {
        try {
            ActionBot.dragAndDrop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void browserBackButtonTest()
    {
        BrowserNavigation.browserBackButtonTest();
    }

}

