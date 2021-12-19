package homeworkselenium;

import org.testng.annotations.Test;

public class Exercise1 extends SeleniumBaseTest {

    @Test
    public void exercise1Test() {
        System.out.println("Exercise1");

        MailPage mpage = new MailPage(driver);

        mpage.loginPage();

        mpage.checkLoginStatus();

        mpage.createEmail("Exercise1");
        mpage.saveEmailToDraft();

        mpage.checkEmailContent("Exercise1");
        mpage.sendEmail("draft");

        mpage.checkDraftIsEmpty();
        mpage.checkOutboxNotEmpty();

        mpage.logoutPage();

        driver.quit();
    }


}

