import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CalcTest {

    public int firstParameter;
    public int secondParameter;
    public int expectedResult;

    public CalcTest(int firstParameter, int secondParameter, int expectedResult) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.expectedResult = expectedResult;
    }

    @Stories("MyStory")
    @Issue("PAAS-2046")
    @Features("Features-F1")
    @Test
    public void checkCalculator() {
        Calculator calculator = new Calculator(firstParameter, secondParameter);
        int result = calculator.getResult();
        assertTrue("Result(" + result + ") isn't equal " + expectedResult, result == expectedResult);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {2, 2, 4},
                {2, 0, 0},
                {-1, 2, -2},
                {0, 2, 0}
        });
    }




}
