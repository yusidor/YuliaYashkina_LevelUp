package homeworkselenium;


import org.testng.annotations.Test;


public class Exercise2 extends SeleniumBaseTest {

    @Test
    public void exercise2Test() {
        System.out.println("Exercise2");

        MailPage mpage = new MailPage(driver);

        mpage.loginPage();

        mpage.checkLoginStatus();
        mpage.createEmail("Тест");
        mpage.sendEmail("Тест");
        mpage.checkOutboxNotEmpty();
        mpage.checkTestNotEmpty();
        mpage.checkEmailContent("Тест");
        mpage.logoutPage();

        driver.quit();
    }


}

