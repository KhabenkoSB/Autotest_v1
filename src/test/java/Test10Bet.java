import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


@Stories("Test Test10Bet")
@Title("Test Test10Bet")
public class Test10Bet {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

/*
       System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
       driver = new FirefoxDriver();
*/

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver2.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.10bet.com";
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @Title("Place 1 single ")
    @Test
    public void testUntitled() throws Exception {
        String bett;
        String myBett;
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/sports/");
        driver.findElement(By.id("NewHeaderUsername")).click();
        driver.findElement(By.id("NewHeaderUsername")).clear();
        driver.findElement(By.id("NewHeaderUsername")).sendKeys("Khabenko");
        driver.findElement(By.id("NewHeaderPassword")).click();
        driver.findElement(By.id("NewHeaderPassword")).clear();
        driver.findElement(By.id("NewHeaderPassword")).sendKeys("Sbtech1!");
        driver.findElement(By.id("NewHeaderLoginButton")).click();
        driver.findElement(By.cssSelector("span.place")).click();
        bett = driver.findElement(By.cssSelector("span.place")).getText();
        driver.findElement(By.id("stake_0")).clear();
        driver.findElement(By.id("stake_0")).sendKeys("1");
        driver.findElement(By.id("PlaceBetButton")).click();
        driver.findElement(By.id("betting_slip_mybetstab")).click();
      //  driver.findElement(By.cssSelector("div.myBetsLine__details")).click();
        driver.findElement(By.cssSelector("span.myBetsLine__pick")).click();
        myBett = driver.findElement(By.cssSelector("span.myBetsLine__pick")).getText();
       // makeScreenshot();
      //  assertEquals(bett, myBett);
        assertTrue(myBett.contains(bett));



    }



    @After
    public void tearDown() throws Exception {
        makeScreenshot();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            makeScreenshot();
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            makeScreenshot();
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            makeScreenshot();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    @Attachment(type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
