package homeworkseleniumtwo;


import homeworkselenium.user.properties.UserProperties;
import org.testng.annotations.Test;

public class Exercise3New extends MailUtils {

    @Test
    public void exercise3Test() {
        System.out.println(UserProperties.SUBJECT3);

        MailMainPage mainpage = new MailMainPage(driver);
        MailPageNew mpage = new MailPageNew(driver);

        mainpage.loginPage();
        mpage.checkLoginStatus();
        mpage.createEmail(UserProperties.SUBJECT3);
        mpage.sendEmail(UserProperties.SUBJECT3);
        mpage.checkInboxNotEmpty();
        mpage.checkEmailContent(UserProperties.SUBJECT3);
        mpage.deleteEmail();
        mpage.checkTrashNotEmpty();
        mpage.logoutPage();

        driver.quit();
    }


}

