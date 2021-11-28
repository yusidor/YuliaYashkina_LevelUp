package homework.functional;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorMultiplyTest extends AbstractBaseCalculatorTest {
    @Test
    public void multiplyTest() {
        System.out.println(this.getClass().getSimpleName() + " multiply test");
        double actualResult = calculator.mult(2.5, 2.0);
        double expectedResult = 5.0;
        Assert.assertEquals(actualResult, expectedResult, 0.001);

    }
}
