package homework.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDataProviderTest extends AbstractBaseCalculatorTest {
    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {3, 2, 5},
                {4, 8, 12},
                {5, 5, 10}
        };
    }


    @Test(dataProvider = "sumDataProvider")
    public void sumTest(int a, int b, int expectedResult) {
        System.out.println("Sum " + a + " and " + b);
        long actualResult = calculator.sum(a, b);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider (name = "Pow Data Provider")
    public Object[][] powDataProvider() {
        return new Object[][] {
                {2.0, 2.0, 4.0},
                {5.0, 2.0, 25.0},

        };
    }


    @Test(dataProvider = "Pow Data Provider")
    public void powTest(double a, double b, double expectedResult) {
        System.out.println(a + " pow " + b);
        double actualResult = calculator.pow(a, b);
        Assert.assertEquals(actualResult, expectedResult);
    }


}
