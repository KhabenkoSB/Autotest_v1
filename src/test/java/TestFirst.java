import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
@Title("Test suite 1")
public class TestFirst {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

        /* for FF
       System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
       */

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://kyiv-win-inf01:9998/routes";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Test
    public void testUntitled() throws Exception {

        driver.get(baseUrl + "/");
        makeScreenshot();
             /*
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("maka");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1");
        driver.findElement(By.cssSelector("button.btn-fill.sign-up-btn")).click();
        try {
            assertEquals("", driver.findElement(By.cssSelector("h1")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        */

    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
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
