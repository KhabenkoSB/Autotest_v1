import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.*;

import javax.swing.text.html.HTML;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
import static ru.yandex.qatools.allure.model.SeverityLevel.NORMAL;

@Title("Test suite")
public class TestSecond {
     private boolean acceptNextAlert = true;
     private StringBuffer verificationErrors = new StringBuffer();
     private String reportHTML;




    @Before
    @Step("Before method is done")
    public void setUp() throws Exception {
        reportHTML = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table border=\"1\">\n" +
                "    <tr>\n" +
                "        <th>Ячейка 1</th>\n" +
                "        <th>Ячейка 2</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Значение 1</td>\n" +
                "        <td>Значение 2</td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";

    }

    @Title("First test in suite")
    @Description("In this test we will test....")
    @Severity(NORMAL)
    @Test
    public void testUntitled() throws Exception {
        saveHtmlAttach("HTML Report", reportHTML);


    }



    @After
    @Step("After method is done")
    public void tearDown() throws Exception {

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {

            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    @Attachment(value = "{0}", type = "text/html")
    public static String saveHtmlAttach(String attachName, String html) {
        return html;
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }

}
