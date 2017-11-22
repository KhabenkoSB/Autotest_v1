import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.*;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static ru.yandex.qatools.allure.model.SeverityLevel.NORMAL;

@Title("Test suite №1")
public class TestSecond {
     private StringBuffer verificationErrors = new StringBuffer();
     private String reportHTML;
     private HttpURLConnection http = new HttpURLConnection();



    @Before
    @Step("Before method is done")
    public void setUp() throws Exception {

        /*
        reportHTML = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table border=\"1\">\n" +
                "    <tr>\n" +
                "        <th>N 1</th>\n" +
                "        <th>N 2</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Value 1</td>\n" +
                "        <td>Value 2</td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
*/
        reportHTML = readHTML();

    }

    @Title("First test in suite")
    @Description("In this test we will test....")
    @Severity(NORMAL)
    @Test
    public void testUntitled() throws Exception {
        assert (http.healthCheck("Sql/DemoAccountingMicroservice")==true);
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

    public String readHTML(){
        String result="";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src\\main\\resources\\report.html"), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                result+=line;
            }
        } catch (IOException e) {
            // log error
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log warning
                }
            }
        }

        return result;
    }

}
