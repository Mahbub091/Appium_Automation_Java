package Utility;

import java.time.Duration;
import java.util.Collections;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
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
    @Step("Waiting for {seconds} seconds")
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }
    @Step("Asserting {text} for {locator}")
    public void assertText(WebElement locator, String text) {
        try {
            Assert.assertEquals(text, locator.getText());
        } catch (Exception e) {
            System.out.println("text assertion: " + e.getMessage());
        }
    }
    @Step("Clicking on ::::::::-> {element}")
    public void clickingOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Click failed for element: " + e.getMessage());
        }
    }
    @Step("Verifying Element  is displayed within {seconds} seconds for ::::::::-> {element}")
    public void elementIsDisplayed(WebElement element, long seconds) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch(Exception e) {
            System.out.println("Element Wait Issue: " + e.getMessage());
        }
    }

    @Step("Verifying {text} is available ::::::::-> {element}")
    public void verifyText(WebElement element, String text) {
        try{
            element.getText().equalsIgnoreCase(text);
            Assert.assertEquals(element.getText(), text);
        } catch(Exception e) {
            System.out.println("Text Verification Failed for element: " + e.getMessage());
        }
    }

    @Step("User clicks on Back Button")
    public void pressBack() {
        try {
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        } catch (Exception e) {
            System.out.println("Back Button Not Pressed: " + e.getMessage());
        }
    }

    @Step("Entering {inputText} on ::::::::-> {element}")
    public void enterText(WebElement element, String inputText) {
        try {
            element.sendKeys(inputText);
        } catch (Exception e) {
            System.out.println("Text Input Failed: " + e.getMessage());
        }
    }

    @Step("Swipping from ::::::::->{swipeEndY} to ::::::::->{swipeStartY}")
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

    @Step("Swiping Right to Left of screen ::::::::->")
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

    @Step("Swiping Bottom to Up of screen ::::::::->")
    public void swipeBottomToUp(String locator) {
        WebElement element;
        try {
            element = driver.findElement(By.xpath(locator));

            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "up",
                    "percent", 1.0
            ));
        } catch (Exception e) {
            System.out.println("Screen Swipe failed: " + e.getMessage());
        }
    }

    @Step("Swiping Hero Animation ::::::::->")
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

    @Step("scrolling to section with ::::::::-> {text}")
    public void scrollToSectionWithText(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" +text+"\"))")).click();
        } catch (Exception e) {
            System.out.println("Found Issue on DailyMovers: " + e.getMessage());
        }
    }

    @Step("scroll and Clicking On ::::::::-> {text}")
    public void clickOnLogOut(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+text+"\"))")).click();
        } catch (Exception e) {
            System.out.println("Found Issue on Log Out: " + e.getMessage());
        }
    }

    @Step("Deleting text from ::::::::-> {element}")
    public void deleteInput(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("Found Issue while clearing Element Inputs: " + e.getMessage());
        }
    }

    @Step("Validating CSS value for {element} on ::::::::->{cssValue} ::::::::->is equal {value}")
    public void getCssValue(WebElement element, String cssValue, String value) {
        try {
            Assert.assertTrue(element.getCssValue(cssValue).equals(value));
        } catch (Exception e) {
            System.out.println("Failed to get CSS value" + e.getMessage());
        }
    }
    @Step("Waiting {seconds} for the Invisibility of ::::::::->{webElement}")
    public void waitForElementInVisibility(WebElement webElement, long seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("Invisibility failed: " + e.getMessage());
        }
    }




}
