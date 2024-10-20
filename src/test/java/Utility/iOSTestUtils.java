package Utility;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

public class iOSTestUtils {
    private final IOSDriver driver;

    public iOSTestUtils(IOSDriver driver)
    {
        this.driver = driver;
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Element Wait Issue" + e.getMessage());
        }
    }

    public void assertText(WebElement locator, String ExpectedText){
        String fetchedText = locator.getText().trim();
        try {
            Assert.assertEquals(fetchedText, ExpectedText, "Fetched text matched expected");
        } catch (Exception e) {
            System.out.println("Text Assert Issue On: " + e.getMessage());
        }
    }

    public void clickingOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Element Click On: " + e.getMessage());
        }
    }

    public void elementIsDisplayed(WebElement element, long seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element Display Issue on: " + e.getMessage());
        }
    }

    public void verifyText(WebElement element, String text) {
        try {
            element.getText().equalsIgnoreCase(text);
            Assert.assertEquals(element.getText(), text);
        } catch (Exception e) {
            System.out.println("Text Verify" + e.getMessage());
        }

    }

    public void swipeScreenToDirection(String directionOfSwipe) {
        try {
            // Get the size of the screen
            HashMap<String, String> scrollObject = new HashMap<>();
            JavascriptExecutor js = driver;
            scrollObject.put("direction", directionOfSwipe);
            js.executeScript("mobile: scroll", scrollObject);

        } catch (Exception e) {
            System.out.println("Swipe Screen Failed: " + e.getMessage());
        }
    }

    public void enterText(WebElement element, String desiredText) {
        try {
            element.sendKeys(desiredText);
        } catch (Exception e) {
            System.out.println("Text Type Failed: " + e.getMessage());
        }
    }

    public void clearText (WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("Text Clear Failed: " + e.getMessage());
        }
    }

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

    public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

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

    public void waitForElementInVisibility(WebElement webElement, long seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("Invisibility failed: " + e.getMessage());
        }
    }

    public boolean validateInputFieldValue(WebElement inputElement, String expectedValue) {
        try {
            // Get the value of the input field
            String actualValue = inputElement.getAttribute("value");

            // Validate the actual value against the expected value
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


}
