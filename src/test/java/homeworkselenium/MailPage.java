package homeworkselenium;

import static org.assertj.core.api.Assertions.assertThat;

import homeworkselenium.user.properties.UserProperties;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MailPage extends SeleniumBaseTest {

    @FindBy(xpath = "//input[@data-testid='login-input']")
    private WebElement mailLogin;

    @FindBy(xpath = "//*[@data-testid=\"mail-remember\"]")
    private WebElement rememberme;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    private WebElement enterPassButton;

    @FindBy(xpath = "//input[@data-testid='password-input']")
    private WebElement passInput;

    @FindBy(xpath = "//*[@data-testid=\"login-to-mail\"]")
    private WebElement  logintomail;


    @FindBy(xpath = "//*[contains(@class,\"svelte-14x1gy5\")]")
    private WebElement logoutDropDown;

    @FindBy(xpath = "//*[contains(@class,\"svelte-1vf03eq\")]/a[text()='']")
    private WebElement logoutFromPage;


    @FindBy(xpath = "//*[@class=\"compose-button__txt\"]")
    private WebElement writeEmailButton;

    @FindBy(xpath = "//*[@data-name='to']//input[@type='text']")
    private WebElement emailTo;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement emailSubject;

    @FindBy(xpath = "//*[@role='textbox']")
    private WebElement emailTextBox;


    @FindBy(xpath = "//*[@title='Сохранить']")
    private WebElement saveToDraft;

    @FindBy(xpath = "//button[@title='Закрыть']")
    private WebElement closeEmailButton;

    @FindBy(xpath = "//a[@href='/drafts/']")
    private WebElement draft;

    @FindBy(xpath = "//*[@class=\"ll-crpt\"]")
    private WebElement draftFieldTo;

    @FindBy(xpath = "//*[@class=\"ll-sj__normal\"]")
    private WebElement draftFieldSubject;

    @FindBy(xpath = "//*[@class=\"ll-sp__normal\"]")
    private WebElement draftFieldText;


    @FindBy(xpath = "//*[@data-title=\"Черновики, 1 письмо\"]")
    private WebElement emailInDraft;

    @FindBy(xpath = "//*[@class ='dataset__empty']")
    private WebElement noEmailsInDraft;


    @FindBy(xpath = "//*[@title='Отправить']")
    private WebElement sendEmail;


    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement outboxFolder;

    @FindBy(xpath = "//*[contains(@class, 'letter-list_has-letters')]")
    private WebElement outboxHasEmails;

    @FindBy(xpath = "//*[contains(@class, button2)]//*[@title='Закрыть']")
    private WebElement closeIcon;


    @FindBy(xpath = "//a[@href='/inbox/']")
    private WebElement inboxFolder;


    @FindBy(xpath = "//*[contains(@class, 'checkbox__box_disabled')")
    private WebElement deleteCheckbox;

    @FindBy(xpath = "//*[@title=\"Удалить\"]")
    private WebElement deleteButton;


    @FindBy(xpath = "//a[@href='/1/']")
    private WebElement testFolder;

    @FindBy(xpath = "//*[contains(@class,'mt-t_tomyself')]")
    private WebElement emailsToMySelf;

    @FindBy(xpath = "//*[@class='ll-av ll-av_size_common ll-av_centered stop-animate']")
    private WebElement navigateElement;


    @FindBy(xpath = "//a[@href='/trash/']")
    private WebElement binFolder;



    public MailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void loginPage() {
        driver.navigate().to(SeleniumBaseTest.MAIL_URL);

        //Enter login
        wait.until(ExpectedConditions
                        .visibilityOf(mailLogin)).clear();
        wait.until(ExpectedConditions
                .visibilityOf(mailLogin)).sendKeys(UserProperties.LOGIN);

        //Uncheck rememberMe
        wait.until(ExpectedConditions
                .visibilityOf(rememberme)).click();


        //Enter password
        wait.until(ExpectedConditions
                .visibilityOf(enterPassButton)).click();
        wait.until(ExpectedConditions
                .visibilityOf(passInput)).sendKeys(UserProperties.PASSWORD);

        wait.until(ExpectedConditions
                .visibilityOf(logintomail)).click();
    }

    public void logoutPage() {

        wait.until(ExpectedConditions
                .visibilityOf(logoutDropDown)).click();

        wait.until(ExpectedConditions
                .visibilityOf(logoutFromPage)).click();

        System.out.println("Logout is ok");


    }

    public void createEmail(String s) {

        wait.until(ExpectedConditions
                .visibilityOf(writeEmailButton)).click();

        wait.until(ExpectedConditions
                .visibilityOf(emailTo)).sendKeys(UserProperties.EMAIL);

        if (s.contains("Тест")) {
            wait.until(ExpectedConditions
                    .visibilityOf(emailSubject)).sendKeys(UserProperties.SUBJECT2);
        } else if (s.contains("Exercise3")) {
            wait.until(ExpectedConditions
                .visibilityOf(emailSubject)).sendKeys(UserProperties.SUBJECT3);
        } else {
            wait.until(ExpectedConditions
                    .visibilityOf(emailSubject)).sendKeys(UserProperties.SUBJECT1);

        }
        wait.until(ExpectedConditions
                .visibilityOf(emailTextBox)).sendKeys(UserProperties.TEXT);

        System.out.println("CreateEmail is ok");
    }

    public void saveEmailToDraft() {

        wait.until(ExpectedConditions
                .visibilityOf(saveToDraft)).click();
        wait.until(ExpectedConditions
                .visibilityOf(closeEmailButton)).click();
        wait.until(ExpectedConditions
                .visibilityOf(draft)).click();

        System.out.println("SaveToDraft is ok");
    }


    public void checkDraftIsEmpty() {

        assertThat(wait.until(ExpectedConditions
                .visibilityOf(noEmailsInDraft)).isDisplayed());
        System.out.println("checkDraftIsEmpty is ok");

    }

    public void checkEmailContent(String s) {

        if (s.contains("Exercise3")) {
            wait.until(ExpectedConditions
                    .visibilityOf(emailsToMySelf)).click();

            //Field To
            assertThat(wait.until(ExpectedConditions
                    .visibilityOf(draftFieldTo)).getText()).isEqualTo(UserProperties.NAME);

            //Field Subject

            assertThat(wait.until(ExpectedConditions
                    .visibilityOf(draftFieldSubject)).getText()).contains(UserProperties.SUBJECT3);

        } else if (s.contains("Тест")) {

            //Field To
            assertThat(wait.until(ExpectedConditions
                   .visibilityOf(draftFieldTo)).getText()).isEqualTo(UserProperties.NAME);

            //Field Subject

            assertThat(wait.until(ExpectedConditions
                        .visibilityOf(draftFieldSubject)).getText()).contains(UserProperties.SUBJECT2);

        } else {
            assertThat(wait.until(ExpectedConditions
                    .visibilityOf(draftFieldTo)).getText()).isEqualTo(UserProperties.EMAIL);

            assertThat(wait.until(ExpectedConditions
                        .visibilityOf(draftFieldSubject)).getText()).isEqualTo(UserProperties.SUBJECT1);
        }
        //Text
        assertThat(wait.until(ExpectedConditions
                .visibilityOf(draftFieldText)).getText()).contains(UserProperties.TEXT);

        System.out.println("CheckContext is ok");

    }


    public void checkOutboxNotEmpty() {

        wait.until(ExpectedConditions
                .visibilityOf(outboxFolder)).click();
        assertThat(wait.until(ExpectedConditions
                .visibilityOf(outboxHasEmails)).isDisplayed());

        System.out.println("checkOutboxNotEmpty is ok");
    }



    public void checkTestNotEmpty() {
        wait.until(ExpectedConditions
                .visibilityOf(testFolder)).click();
        assertThat(wait.until(ExpectedConditions
                .visibilityOf(outboxHasEmails)).isDisplayed());

        System.out.println("checkTestNotEmpty is ok");


    }

    public void checkLoginStatus() {
        assertThat(wait.until(ExpectedConditions
                            .visibilityOf(draft)).getText()).contains(UserProperties.DRAFT_FOLDER);
        System.out.println("Login is ok");
    }

    public void sendEmail(String s) {
        if (s.equals("draft")) {
            wait.until(ExpectedConditions
                    .visibilityOf(draftFieldTo)).click();

        }

        wait.until(ExpectedConditions
                .visibilityOf(sendEmail)).click();


        System.out.println("SendEmail is ok");


    }


    public void deleteEmail() {
        wait.until(ExpectedConditions
                .visibilityOf(inboxFolder)).click();


        wait.until(ExpectedConditions
                .visibilityOf(emailsToMySelf)).isDisplayed();



        wait.until(ExpectedConditions
               .visibilityOf(navigateElement)).click();

        wait.until(ExpectedConditions
                .visibilityOf(deleteButton)).click();

        System.out.println("deleteEmail is ok");


    }

    public void checkInboxNotEmpty() {
        wait.until(ExpectedConditions
                .visibilityOf(inboxFolder)).click();


        assertThat(wait.until(ExpectedConditions
                .visibilityOf(outboxHasEmails)).isDisplayed());

        System.out.println("checkInboxNotEmpty is ok");



    }

    public void checkTrashNotEmpty() {
        wait.until(ExpectedConditions
                .visibilityOf(binFolder)).click();


        assertThat(wait.until(ExpectedConditions
                .visibilityOf(outboxHasEmails)).isDisplayed());

        System.out.println("checkTrashNotEmpty is ok");
    }



}











