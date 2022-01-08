package homeworkseleniumtwo;

import homeworkselenium.user.properties.UserProperties;
import org.testng.annotations.Test;

public class Exercise1New extends SeleniumBaseTestNew {

    @Test
    public void exercise1Test() {
        System.out.println(UserProperties.SUBJECT1);

        MailMainPage mainpage = new MailMainPage(driver);
        MailPageNew mpage = new MailPageNew(driver);

        mainpage.loginPage();
        mpage.checkLoginStatus();
        mpage.createEmail(UserProperties.SUBJECT1);
        mpage.saveEmailToDraft();
        mpage.checkEmailContent(UserProperties.SUBJECT1);
        mpage.sendEmail(UserProperties.SUBJECT1);
        mpage.checkDraftIsEmpty();

        mpage.checkOutboxNotEmpty();
        mpage.logoutPage();

        driver.quit();
    }


}

