import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.concurrent.TimeUnit;


public class Steps {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {

/*
       System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
       driver = new FirefoxDriver();
*/

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver2.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.10bet.com";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Given("^I have login$")
    public void iHaveLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("ReadLoginFromFile");

        makeScreenshot();
    }

    @When("^I am logining to (\\d+)bet$")
    public void iAmLoginingToBet(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("2");
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/sports/");
        driver.findElement(By.id("NewHeaderUsername")).clear();
        driver.findElement(By.id("NewHeaderUsername")).sendKeys("Khabenko");
        driver.findElement(By.id("NewHeaderPassword")).click();
        driver.findElement(By.id("NewHeaderPassword")).clear();
        driver.findElement(By.id("NewHeaderPassword")).sendKeys("Sbtech1!");
        driver.findElement(By.id("NewHeaderLoginButton")).click();
        makeScreenshot();
    }

    @Then("^I can see balase$")
    public void iCanSeeBalase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("3");
        makeScreenshot();
    }

    @Then("^I can see error$")
    public void iCanSeeError() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/sports/");
        driver.findElement(By.id("NewHeaderUsername")).clear();
        driver.findElement(By.id("NewHeaderUsername")).sendKeys("Khabenko");
        driver.findElement(By.id("NewHeaderPassword")).click();
        driver.findElement(By.id("NewHeaderPassword")).clear();
        driver.findElement(By.id("NewHeaderPassword")).sendKeys("Sbtech1!");
        driver.findElement(By.id("NewHeaderLoginButton")).click();
        makeScreenshot();
        System.out.println("4");
        makeScreenshot();
   }




    @Attachment(type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}


