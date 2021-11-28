package homework.functional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.calculator.Calculator;


@SuppressWarnings("checkstyle:Indentation")
public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

    @BeforeClass
    public void setUpClass() {
        System.out.println(this.getClass().getSimpleName() + " set up class");
        System.out.println();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getSimpleName() + " set up method");
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(this.getClass().getSimpleName() + " tear down method");
        System.out.println();
        calculator = null;
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println(this.getClass().getSimpleName() + " tear down class");
        System.out.println("=======");
    }

}
