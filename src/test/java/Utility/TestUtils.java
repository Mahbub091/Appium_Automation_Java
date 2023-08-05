package Utility;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestUtils {

    WebDriver driver;
    Logger log = LogManager.getLogger("TestUtils");
    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(int seconds) {
        log.info("Test Paused : [{}] Seconds", seconds);
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertText(WebElement locator, String text){
        try {
            Assert.assertTrue(locator.getText().equals(text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickingOnElement(WebElement element) {
        log.info("Clicking On Element: [{}]", element);
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elementIsDisplayed(WebElement element, long seconds) {
        log.info("Waiting for [{}] seconds on Visibility of [{}]", seconds, element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyText(WebElement element, String text) {
        log.info("Fetching text from [{}] & verifying [{}]", element, text);
        element.getText().equalsIgnoreCase(text);
        Assert.assertEquals(element.getText(), text);
    }
}
