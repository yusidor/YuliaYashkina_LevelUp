package homeworkseleniumtwo;

import static org.assertj.core.api.Assertions.assertThat;

import homeworkselenium.user.properties.UserProperties;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MailPageNew extends MailUtils {

    //create email
    @FindBy(xpath = "//*[@class=\"compose-button__txt\"]")
    public static WebElement writeEmailButton;

    @FindBy(xpath = "//*[@data-name='to']//input[@type='text']")
    public static WebElement emailTo;

    @FindBy(xpath = "//input[@name='Subject']")
    public static WebElement emailSubject;

    @FindBy(xpath = "//*[@role='textbox']")
    public static WebElement emailTextBox;

    //save email
    @FindBy(xpath = "//*[@title='Сохранить']")
    public static WebElement saveToDraft;

    @FindBy(xpath = "//button[@title='Закрыть']")
    public static WebElement closeEmailButton;

    //draft folder
    @FindBy(xpath = "//a[@href='/drafts/']")
    public static WebElement draft;

    //email context
    @FindBy(xpath = "//*[@class=\"ll-crpt\"]")
    public static WebElement draftFieldTo;

    @FindBy(xpath = "//*[@class=\"ll-sj__normal\"]")
    public static WebElement draftFieldSubject;

    @FindBy(xpath = "//*[@class=\"ll-sp__normal\"]")
    public static WebElement draftFieldText;

    @FindBy(xpath = "//*[@class ='dataset__empty']")
    public static WebElement noEmailsInDraft;

    //send email
    @FindBy(xpath = "//*[@title='Отправить']")
    public static WebElement sendEmail;

    //email status
    @FindBy(xpath = "//*[contains(@class,'nav_expanded')]//a[@href='/sent/']")
    public static WebElement outboxFolder;

    @FindBy(xpath = "//*[contains(@class, 'letter-list_has-letters')]")
    public static WebElement outboxHasEmails;


    @FindBy(xpath = "//a[@href='/inbox/']")
    public static WebElement inboxFolder;

    //delete email
    @FindBy(xpath = "//*[@title=\"Удалить\"]")
    public static WebElement deleteButton;

    //test folder
    @FindBy(xpath = "//a[@href='/1/']")
    public static WebElement testFolder;

    @FindBy(xpath = "//*[contains(@class,'mt-t_tomyself')]")
    public static WebElement emailsToMySelf;

    @FindBy(xpath = "//*[@class='ll-av ll-av_size_common ll-av_centered stop-animate']")
    public static WebElement navigateElement;

    //trash folder
    @FindBy(xpath = "//a[@href='/trash/']")
    public static WebElement binFolder;

    //logout
    @FindBy(xpath = "//*[contains(@class,\"svelte-14x1gy5\")]")
    public static WebElement logoutDropDown;

    @FindBy(xpath = "//*[contains(@class,\"svelte-1vf03eq\")]/a[text()='']")
    public static WebElement logoutFromPage;




    public MailPageNew(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void checkLoginStatus() {
        assertThat(getTextFromWebElement(draft)).contains(UserProperties.DRAFT_FOLDER);

        System.out.println("Login is ok");
    }

    public void createEmail(String s) {

        clickToWebElement(writeEmailButton);
        sendKeysToWebElement(emailTo, UserProperties.EMAIL);

        if (s.contains(UserProperties.SUBJECT2)) {
            sendKeysToWebElement(emailSubject, UserProperties.SUBJECT2);
        } else if (s.contains(UserProperties.SUBJECT3)) {
            sendKeysToWebElement(emailSubject, UserProperties.SUBJECT3);
        } else {
            sendKeysToWebElement(emailSubject, UserProperties.SUBJECT1);
        }
        sendKeysToWebElement(emailTextBox, UserProperties.TEXT);

        System.out.println("CreateEmail is ok");
    }

    public void saveEmailToDraft() {

        clickToWebElement(saveToDraft);
        clickToWebElement(closeEmailButton);
        clickToWebElement(draft);

        System.out.println("SaveToDraft is ok");
    }


    public void checkDraftIsEmpty() {

        assertThat(getTextFromWebElement(noEmailsInDraft)).contains(UserProperties.MESSAGE_NO_EMAILS_IN_DRAFT);

        System.out.println("checkDraftIsEmpty is ok");
    }

    public void checkEmailContent(String s) {

        if (s.contains(UserProperties.SUBJECT3)) {
            clickToWebElement(emailsToMySelf);

            //Field To
            assertThat(getTextFromWebElement(draftFieldTo)).isEqualTo(UserProperties.NAME);

            //Field Subject

            assertThat(getTextFromWebElement(draftFieldSubject)).contains(UserProperties.SUBJECT3);

        } else if (s.contains(UserProperties.SUBJECT2)) {

            //Field To
            assertThat(getTextFromWebElement(draftFieldTo)).isEqualTo(UserProperties.NAME);

            //Field Subject

            assertThat(getTextFromWebElement(draftFieldSubject)).contains(UserProperties.SUBJECT2);

        } else {
            assertThat(getTextFromWebElement(draftFieldTo)).isEqualTo(UserProperties.EMAIL);

            assertThat(getTextFromWebElement(draftFieldSubject)).isEqualTo(UserProperties.SUBJECT1);
        }
        //Text
        assertThat(getTextFromWebElement(draftFieldText)).contains(UserProperties.TEXT);

        System.out.println("CheckContext is ok");

    }


    public void checkOutboxNotEmpty() {

        clickToWebElement(outboxFolder);
        assertThat(getTextFromWebElement(outboxHasEmails)).contains(UserProperties.EMAIL);

        System.out.println("checkOutboxNotEmpty is ok");
    }



    public void checkTestNotEmpty() {
        clickToWebElement(testFolder);
        assertThat(getTextFromWebElement(outboxHasEmails)).contains(UserProperties.NAME);

        System.out.println("checkTestNotEmpty is ok");


    }

    public void sendEmail(String s) {
        if (s.equals(UserProperties.SUBJECT1)) {
            clickToWebElement(draftFieldTo);
        }
        clickToWebElement(sendEmail);

        System.out.println("SendEmail is ok");


    }


    public void deleteEmail() {
        clickToWebElement(inboxFolder);
        webElementIsDisplayed(emailsToMySelf);
        clickToWebElement(navigateElement);
        clickToWebElement(deleteButton);

        System.out.println("deleteEmail is ok");


    }

    public void checkInboxNotEmpty() {
        clickToWebElement(inboxFolder);
        assertThat(getTextFromWebElement(outboxHasEmails)).contains(UserProperties.EMAIL);

        System.out.println("checkInboxNotEmpty is ok");

    }

    public void checkTrashNotEmpty() {
        clickToWebElement(binFolder);
        assertThat(wait.until(ExpectedConditions
                .visibilityOf(outboxHasEmails)).getText()).contains(UserProperties.EMAIL);

        System.out.println("checkTrashNotEmpty is ok");
    }

    public void logoutPage() {

        clickToWebElement(logoutDropDown);
        clickToWebElement(logoutFromPage);

        System.out.println("Logout is ok");
    }

}











