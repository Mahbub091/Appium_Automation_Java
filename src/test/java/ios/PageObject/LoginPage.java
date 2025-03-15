package ios.PageObject;

import Utility.iOSTestUtils;
import com.github.javafaker.Faker;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    Faker faker = new Faker();

    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;

    public LoginPage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        iosUtils = new iOSTestUtils(iosDriver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign up\"]")
    WebElement loginFormButton;

    @iOSXCUITFindBy(accessibility = "Login")
    WebElement loginMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login / Sign up Form\"]")
    WebElement successButton;


    /**
     * We wil create our functions here.
     */

    public void attemptingIncompleteEmailLogin () {
        iosUtils.elementIsDisplayed(loginMenu, extended_element_find);
        iosUtils.clickingOnElement(loginMenu);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
    }

    public void attemptingWrongPasswordLogin () {
        iosUtils.elementIsDisplayed(loginMenu, extended_element_find);
        iosUtils.clickingOnElement(loginMenu);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
        iosUtils.elementIsDisplayed(successButton, short_element_find);
        iosUtils.clickingOnElement(successButton);
        iosUtils.waitForElementInVisibility(successButton, short_element_find);
    }

    public void attemptingRandomEmailLogin () {
        iosUtils.elementIsDisplayed(loginMenu, extended_element_find);
        iosUtils.clickingOnElement(loginMenu);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
    }

    public void populatingTheSignUpForm () {
        // same as login function but for sign up page.
        // We would have to call this function when we want to test sign up functionality.
        iosUtils.elementIsDisplayed(successButton, short_element_find);
        iosUtils.clickingOnElement(successButton);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
        iosUtils.wait(2);

    }












}
