package homework.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowerTest extends AbstractBaseCalculatorTest {


    @Test
    public void positivePowerTest() {
        System.out.println(this.getClass().getSimpleName() + " positive power test");
        double actualResult = calculator.pow(2.0, 5);
        double expectedResult = Math.pow(2.0, 5);
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}
