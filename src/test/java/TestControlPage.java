import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public  class TestControlPage
{

    static WebDriver driver;
    static Wait<WebDriver> wait;
    static String pageUrl;

    TestControlPage()

    {
        System.setProperty(TestDataGenerator.setPropDriver,TestDataGenerator.setDriverPath );
        driver = new ChromeDriver();
    }

    public static void driverClose()
    {
        driver.close();
    }

    public static void googleKeepTest()
    {
        driver.get(TestDataGenerator.googleKeepUrl);

        //mail login form
        WebElement el = driver.findElement(By.id("identifierId"));
        el.sendKeys(TestDataGenerator.googleLoginID);

        driver.findElements(By.id("identifierNext")).get(0).click();

        wait = new WebDriverWait(driver, 300);
        //password form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
        driver.findElements(By.id("passwordNext")).get(0).click();

        WebElement e2 = (new WebDriverWait(driver, 30000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='whsOnd zHQkBf']")));
        e2.sendKeys(TestDataGenerator.googleLoginPwd);
        driver.findElements(By.id("passwordNext")).get(0).click();
        driver.manage().timeouts().pageLoadTimeout(30, SECONDS);

        //getTitle
        System.out.println("Title of the page:: " + driver.getTitle());


   //     String filePath = "C:/Users/wEll/IdeaProjects/test-master/selenium4/src/test/resources/pixiLogo.png";

        WebElement e3 = (new WebDriverWait(driver, 3000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='New list']")));

        driver.findElements(By.xpath("//div[@aria-label='New list']")).get(0).click();
        driver.findElements(By.xpath("//div[@contenteditable='true']")).get(0).sendKeys("Sites to be testing are following");
        driver.findElements(By.xpath("//div[@contenteditable='true']")).get(0).sendKeys(Keys.RETURN);
        driver.findElements(By.xpath("//div[@contenteditable='true']")).get(1).sendKeys("https://keep.google.com/");
        driver.findElements(By.xpath("//div[@contenteditable='true']")).get(2).sendKeys("http://www.tinyupload.com/");
        driver.findElements(By.xpath("//div[@contenteditable='true']")).get(3).sendKeys("http://spreadsheetpage.com/index.php/file/C35/P10/");


        //logout
      //  driver.findElement(By.xpath("//a[@href='https://accounts.google.com/Logout']")).click();



    }



    public static void cookieSet()
    {
        System.out.println("cookie called");

        String URL=TestDataGenerator.tinyUrl;
        driver.navigate().to(URL);

        Cookie name = new Cookie("seleniumTestCookie", "SeeThisProvesIHaveManipulatedTheCookie.It has more nuts now");
        driver.manage().addCookie(name);

        // After adding the cookie we will check that by displaying all the cookies.
        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
        System.out.println("cookie end");

    }

    public static void fluentWaitTest()
    {
        //fluent wait

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

    }

    public static void uploadTest()
    {
        String baseUrl = TestDataGenerator.tinyUrl;
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.name("uploaded_file"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys(TestDataGenerator.uploadPath);

        driver.findElement(By.xpath("//img[@src='images/button_upload.gif']")).click();

    }

    public static void downloadTest()
    {
        //download
        driver.get(TestDataGenerator.downloadUrl);

        driver.findElement(By.linkText("smilechart.xls")).click();

    }
    public static void multiStaticPageTest()
    {
        ArrayList<String> arrayLinks = new ArrayList<String>();
        driver.get(TestDataGenerator.googleUrl);
        arrayLinks.add(TestDataGenerator.googleKeepUrl);
        arrayLinks.add(TestDataGenerator.tinyUrl);
        for (String ele: arrayLinks )
        {
            driver.get(ele);

        }

    }

    public static void RandomStaticTest()
    {

        //download
        driver.get(TestDataGenerator.downloadUrl);
        int randNumberHere = TestRandomCase.returnOneRand();

        driver.findElements(By.xpath("//a[text()='[Item URL]']")).get(randNumberHere).click();

        System.out.println("Randomly Clicked at a link containg [Item URL] link number : "+ randNumberHere);//+driver.findElements(By.xpath("//a[text()='[Item URL]']")).get(randNumberHere));
    }


}

