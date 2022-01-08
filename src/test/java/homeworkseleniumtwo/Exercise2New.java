package homeworkseleniumtwo;

import homeworkselenium.user.properties.UserProperties;
import org.testng.annotations.Test;

public class Exercise2New extends  SeleniumBaseTestNew {

    @Test
    public void exercise2Test() {
        System.out.println("Exercise2");

        MailMainPage mainpage = new MailMainPage(driver);
        MailPageNew mpage = new MailPageNew(driver);

        mainpage.loginPage();
        mpage.checkLoginStatus();
        mpage.createEmail(UserProperties.SUBJECT2);
        mpage.sendEmail(UserProperties.SUBJECT2);
        mpage.checkOutboxNotEmpty();
        mpage.checkTestNotEmpty();
        mpage.checkEmailContent(UserProperties.SUBJECT2);
        mpage.logoutPage();

        driver.quit();
    }


}

