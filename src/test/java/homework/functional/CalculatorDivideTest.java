package homework.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends AbstractBaseCalculatorTest {

    @Test
    public void divideTest() {
        System.out.println(this.getClass().getSimpleName() + " positive divide int test");
        double actualResult = calculator.div(10.0, 4.0);
        double expectedResult = 2.5;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}
