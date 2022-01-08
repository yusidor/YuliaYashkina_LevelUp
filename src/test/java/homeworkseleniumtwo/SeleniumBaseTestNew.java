package homeworkseleniumtwo;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class SeleniumBaseTestNew {
    public static final String MAIL_URL = "https://mail.ru";
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
