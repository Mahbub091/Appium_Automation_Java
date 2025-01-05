package Utility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class iOSTestUtils {
    private final IOSDriver driver;

    public iOSTestUtils(IOSDriver driver)
    {
        this.driver = driver;
    }

    @Step("Waiting for :------------------------> {seconds}")
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Element Wait Issue" + e.getMessage());
        }
    }

    @Step("Validating {expectedText} on : -------------> {locator}")
    public void assertText(WebElement locator, String expectedText){
        String fetchedText = locator.getText().trim();
        try {
            Assert.assertEquals(fetchedText, expectedText, "Fetched text matched expected");
        } catch (Exception e) {
            System.out.println("Text Assert Issue On: " + e.getMessage());
        }
    }

    @Step("Clicking On : ----------> {element}")
    public void clickingOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Element Click On: " + e.getMessage());
        }
    }

    @Step("Validating element is Displayed : ----------> {element}")
    public void elementIsDisplayed(WebElement element, long seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element Display Issue on: " + e.getMessage());
        }
    }

    @Step("Validating {text} to be present : ----------> {element}")
    public void verifyText(WebElement element, String text) {
        try {
            element.getText().equalsIgnoreCase(text);
            Assert.assertEquals(element.getText(), text);
        } catch (Exception e) {
            System.out.println("Text Verify" + e.getMessage());
        }

    }

    @Step("Performing Swipe on Screen : ----------> {directionOfSwipe}")
    public void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    @Step("Entering {desiredText} on : ----------> {element}")
    public void enterText(WebElement element, String desiredText) {
        try {
            element.clear();
            element.sendKeys(desiredText);
            System.out.println("Text entered successfully: " + desiredText);
        } catch (Exception e) {
            System.out.println("Text entry failed: " + e.getMessage());
        }
    }


    @Step("Clearing text on :-----------> {element}")public void clearText (WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("Text Clear Failed: " + e.getMessage());
        }
    }

    @Step("Tapping on element using :-----------> {x} N {y}")
    public void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(150)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
        System.out.println("Tap with Coordinates");
    }

    @Step("Validating element to have text : ----------------{element}----------------{expectedText}")
    public void containsText (WebElement element, String expectedText) {
        try {
            String actualText = element.getText();
            System.out.println(actualText);
            Assert.assertTrue(actualText.contains(expectedText),
                    "Actual text does not contain expected text. Actual: " + actualText + ", Expected: " + expectedText);
        } catch (Exception e) {
            System.out.println("Expected Text not found: " + e.getMessage());
        }
    }

    @Step("Selecting {value} from dropdown list on : ----------------> {element} ")
    public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    @Step("Hiding keyboard")
    public void hideKeyboard() {
        try {
            // Hide the keyboard if it is displayed
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
                System.out.println("Keyboard hidden successfully.");
            } else {
                System.out.println("Keyboard is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to hide the keyboard: " + e.getMessage());
        }
    }

    @Step("Waiting for element to be invisible :----------> {element} :::::::within {seconds} seconds")
    public void waitForElementInVisibility(WebElement webElement, long seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("Invisibility failed: " + e.getMessage());
        }
    }

    @Step("Validating Inout field to have {expectedValue} for :::----------------> {inputElement}")
    public boolean validateInputFieldValue(WebElement inputElement, String expectedValue) {
        try {
            String actualValue = inputElement.getAttribute("value");

            if (actualValue.equals(expectedValue)) {
                System.out.println("Validation successful: The value is correct.");
                return true;
            } else {
                System.out.println("Validation failed: Expected value '" + expectedValue + "' but got '" + actualValue + "'");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Failed to validate input field value: " + e.getMessage());
            return false;
        }
    }

    @Step("Scrolling to element with text : ----------------> {text}")
    public WebElement scrollToElement(String text) {
        HashMap<String, Object> scrollArgs = new HashMap<>();
        scrollArgs.put("direction", "down");
        scrollArgs.put("name", text);

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS '" + text + "'"));
        driver.executeScript("mobile: scroll", scrollArgs);

        return element;
    }


}
