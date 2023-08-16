package Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestUtils {

    private AndroidDriver driver;

    public TestUtils(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void wait(int seconds) {
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
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elementIsDisplayed(WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyText(WebElement element, String text) {
        element.getText().equalsIgnoreCase(text);
        Assert.assertEquals(element.getText(), text);
    }

    public void pressBack() {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
