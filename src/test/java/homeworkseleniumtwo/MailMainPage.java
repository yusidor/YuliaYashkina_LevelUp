package homeworkseleniumtwo;

import homeworkselenium.user.properties.UserProperties;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MailMainPage extends MailUtils {

    @FindBy(xpath = "//input[@data-testid='login-input']")
    public static WebElement mailLogin;

    @FindBy(xpath = "//*[@data-testid=\"mail-remember\"]")
    public static WebElement rememberme;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    public static WebElement enterPassButton;

    @FindBy(xpath = "//input[@data-testid='password-input']")
    public static WebElement passInput;

    @FindBy(xpath = "//*[@data-testid=\"login-to-mail\"]")
    public static WebElement  logintomail;

    public MailMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void loginPage() {
        driver.navigate().to(SeleniumBaseTestNew.MAIL_URL);

        //Enter login
        clearWebElement(mailLogin);
        sendKeysToWebElement(mailLogin, UserProperties.LOGIN);

        //Uncheck rememberMe
        clickToWebElement(rememberme);

        //Enter password
        clickToWebElement(enterPassButton);
        sendKeysToWebElement(passInput, UserProperties.PASSWORD);
        clickToWebElement(logintomail);
    }


}
