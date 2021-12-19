package homeworkselenium;


import org.testng.annotations.Test;


public class Exercise3 extends SeleniumBaseTest {

    @Test
    public void exercise3Test() {
        System.out.println("Exercise3");

        MailPage mpage = new MailPage(driver);

        mpage.loginPage();
        mpage.checkLoginStatus();
        mpage.createEmail("Exercise3");
        mpage.sendEmail("Exercise3");
        mpage.checkInboxNotEmpty();
        mpage.checkEmailContent("Exercise3");
        mpage.deleteEmail();
        mpage.checkTrashNotEmpty();
        mpage.logoutPage();

        driver.quit();
    }


}

