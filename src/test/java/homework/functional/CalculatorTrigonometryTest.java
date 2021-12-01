package homework.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTrigonometryTest extends AbstractBaseCalculatorTest {
    @Test
    public void sinTest() {
        System.out.println(this.getClass().getSimpleName() + " sin test");
        double actualResult = calculator.sin(0.0);
        double expectedResult = Math.sin(0.0);
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
    /*
    @Test
    public void cosTest() {
        System.out.println(this.getClass().getSimpleName() + " cos test");
        double actualResult = calculator.cos(0.0);
        double expectedResult = Math.cos(0.0);
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
*/

}
