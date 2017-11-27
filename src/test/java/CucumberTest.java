import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

@Stories("Test Cucumber")
@Title("Test Cucumber")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "",
        tags = "@withdrawal",
        snippets = SnippetType.CAMELCASE
)


public class CucumberTest {


}
