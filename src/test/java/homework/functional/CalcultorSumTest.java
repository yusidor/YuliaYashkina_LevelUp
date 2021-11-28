package homework.functional;

import homework.functional.AbstractBaseCalculatorTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcultorSumTest extends AbstractBaseCalculatorTest {

    @Test
    public void sumTest() {
        System.out.println(this.getClass().getSimpleName() + " sum test");
        long actualResult = calculator.sum(2, 3);
        long expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }

}


