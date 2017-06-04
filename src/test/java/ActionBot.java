import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ActionBot{

    public static WebDriver driver;
    public static Wait<WebDriver> wait;


    public static void hoverTest()
    {

        System.setProperty(TestDataGenerator.setPropDriver, TestDataGenerator.setDriverPath );
        driver = new ChromeDriver();

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

        //     String filePath = "C:/Users/wEll/IdeaProjects/test-master/selenium4/src/test/resources/pixiLogo.png";

        WebElement e3 = (new WebDriverWait(driver, 3000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='New list']")));



        WebElement e4 = (new WebDriverWait(driver, 3000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sites to be testing are following']")));
        e4.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        // Google apps

        //WebElement e5 = (new WebDriverWait(driver, 3000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Change color']")));
        //e5.click();

        WebElement element = driver.findElement(By.xpath("//div[@aria-label='Change color']"));


        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();


        driver.findElement(By.xpath("//div[@aria-label='Red']")).click();

    }


    public static void dragAndDrop() throws InterruptedException {

        System.setProperty(TestDataGenerator.setPropDriver, TestDataGenerator.setDriverPath );
        driver = new ChromeDriver();

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

        //     String filePath = "C:/Users/wEll/IdeaProjects/test-master/selenium4/src/test/resources/pixiLogo.png";

        WebElement e3 = (new WebDriverWait(driver, 3000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='New list']")));



        //WebElement e4 = (new WebDriverWait(driver, 3000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sites to be testing are following']")));
        //e4.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement From = driver.findElement(By.xpath("//div[text()='Pinned']"));

        WebElement To = driver.findElement(By.xpath("//div[text()='Others']"));

        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(From)

                .moveToElement(To)

                .release(To)

                .build();

        dragAndDrop.perform();

    }

}