package homeworkseleniumtwo;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MailUtils extends SeleniumBaseTestNew {

    void clearWebElement(WebElement element) {
        wait.until(ExpectedConditions
                .visibilityOf(element)).clear();
    }

    void sendKeysToWebElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    void clickToWebElement(WebElement element) {
        wait.until(ExpectedConditions
                .visibilityOf(element)).click();


    }


    void webElementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions
                .visibilityOf(element));


    }

    String getTextFromWebElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }


}
