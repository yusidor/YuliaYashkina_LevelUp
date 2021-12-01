package homework.functional;

import homework.functional.AbstractBaseCalculatorTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcultorSubtractTest  extends AbstractBaseCalculatorTest {

    @Test
    public void subtractTest() {
        System.out.println(this.getClass().getSimpleName() + " subtract test");
        double actualResult = calculator.sub(2.0, -3.05);
        double expectedResult = 5.05;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}


