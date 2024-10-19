package Utility;

import java.time.Duration;
import java.util.Collections;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestUtils {

    private final AndroidDriver driver;

    public TestUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }

    public void assertText(WebElement locator, String text) {
        try {
            Assert.assertTrue(locator.getText().equals(text));
        } catch (Exception e) {
            System.out.println("text assertion: " + e.getMessage());
        }
    }

    public void clickingOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Click failed for element: " + e.getMessage());
        }
    }

    public void elementIsDisplayed(WebElement element, long seconds) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch(Exception e) {
            System.out.println("Element Wait Issue: " + e.getMessage());
        }
    }

    public void verifyText(WebElement element, String text) {
        try{
            element.getText().equalsIgnoreCase(text);
            Assert.assertEquals(element.getText(), text);
        } catch(Exception e) {
            System.out.println("Text Verification Failed for element: " + e.getMessage());
        }
    }

    public void pressBack() {
        try {
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        } catch (Exception e) {
            System.out.println("Back Button Not Pressed: " + e.getMessage());
        }
    }

    public void enterText(WebElement element, String inputText) {
        try {
            element.sendKeys(inputText);
        } catch (Exception e) {
            System.out.println("Text Input Failed: " + e.getMessage());
        }
    }


    public void swipeUp( int swipeEndY, int swipeStartY) {
        try{
            Dimension size = driver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = swipeStartY;
            int endX = startX;
            int endY = swipeEndY;
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, swipeStartY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
        }catch(Exception e){
            System.out.println("Screen UP swipe failed: " + e.getMessage());
        }
    }

    public void swipeRightToLeft() {
        WebElement element = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='5']"));

        try{
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "left",
                    "percent", .80
            ));
        } catch (Exception e) {
            System.out.println("Screen Swipe failed: " + e.getMessage());
        }
    }

    public void swipeBottomToUp() {
        WebElement element = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\'com.techetronventures.trek:id/lottieSwipeAnimation\']"));

        try{
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "up",
                    "percent", 1.0
            ));
        } catch (Exception e) {
            System.out.println("Screen Swipe failed: " + e.getMessage());
        }
    }

    public void heroAnimationSwipe() {
        WebElement element = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[index=0]"));
        try{
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "left",
                    "percent", 1.0
            ));
        } catch (Exception e) {
            System.out.println("Failed to execute" + e.getMessage());
        }
    }

    public void scrollToSectionWithText(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" +text+"\"))")).click();
        } catch (Exception e) {
            System.out.println("Found Issue on DailyMovers: " + e.getMessage());
        }
    }

    public void clickOnLogOut() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Log out\"))")).click();
        } catch (Exception e) {
            System.out.println("Found Issue on Log Out: " + e.getMessage());
        }
    }

    public void deleteInput(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("Found Issue while clearing Element Inputs: " + e.getMessage());
        }
    }

    public void getCssValue(WebElement element, String cssValue, String value) {
        try {
            Assert.assertTrue(element.getCssValue(cssValue).equals(value));
        } catch (Exception e) {
            System.out.println("Failed to get CSS value" + e.getMessage());
        }
    }

    public void waitForElementInVisibility(WebElement webElement, long seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("Invisibility failed: " + e.getMessage());
        }


    }




}
