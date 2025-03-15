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
        iosUtils.elementIsDisplayed(loginEmailField, extended_element_find);
        iosUtils.enterText(loginEmailField, "mahbub");
        iosUtils.hideKeyboard();
        iosUtils.validateInputFieldValue(loginEmailField, "mahbub");
        iosUtils.elementIsDisplayed(loginPasswordField, short_element_find);
        iosUtils.enterText(loginPasswordField, "1234");
        iosUtils.hideKeyboard();
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
    }

    public void attemptingWrongPasswordLogin () {
        iosUtils.elementIsDisplayed(loginMenu, extended_element_find);
        iosUtils.clickingOnElement(loginMenu);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
        iosUtils.elementIsDisplayed(loginEmailField, extended_element_find);
        iosUtils.enterText(loginEmailField, "mahbubasr88@gmail.com");
        iosUtils.hideKeyboard();
        iosUtils.validateInputFieldValue(loginEmailField, "mahbubasr88@gmail.com");
        iosUtils.elementIsDisplayed(loginPasswordField, short_element_find);
        iosUtils.enterText(loginPasswordField, "7656545456465465435");
        iosUtils.hideKeyboard();
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.elementIsDisplayed(successButton, short_element_find);
        iosUtils.clickingOnElement(successButton);
        iosUtils.waitForElementInVisibility(successButton, short_element_find);
    }

    public void attemptingRandomEmailLogin () {
        iosUtils.elementIsDisplayed(loginMenu, extended_element_find);
        iosUtils.clickingOnElement(loginMenu);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
        iosUtils.elementIsDisplayed(loginEmailField, extended_element_find);
        iosUtils.enterText(loginEmailField, faker.internet().emailAddress());
        iosUtils.hideKeyboard();
        iosUtils.validateInputFieldValue(loginEmailField, faker.internet().emailAddress());
        iosUtils.elementIsDisplayed(loginPasswordField, short_element_find);
        iosUtils.enterText(loginPasswordField, "tyfygfhgt6r5654");
        iosUtils.hideKeyboard();
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
    }

    public void populatingTheSignUpForm () {
        // same as login function but for sign up page.
        // We would have to call this function when we want to test sign up functionality.
        iosUtils.elementIsDisplayed(signUpFormButton, short_element_find);
        iosUtils.clickingOnElement(signUpFormButton);
        iosUtils.elementIsDisplayed(signUpFormEmail, extended_element_find);
        iosUtils.clearText(signUpFormEmail);
        iosUtils.enterText(signUpFormEmail, faker.internet().emailAddress());
        iosUtils.elementIsDisplayed(signUpFormPassword, extended_element_find);
        iosUtils.clearText(signUpFormPassword);
        iosUtils.enterText(signUpFormPassword, "12345678");
        iosUtils.elementIsDisplayed(signUpFormConfirmPassword, extended_element_find);
        iosUtils.clearText(signUpFormConfirmPassword);
        iosUtils.enterText(signUpFormConfirmPassword, "12345678");
        iosUtils.elementIsDisplayed(signUpButton, short_element_find);
        iosUtils.clickingOnElement(signUpButton);
        iosUtils.elementIsDisplayed(successButton, short_element_find);
        iosUtils.clickingOnElement(successButton);
        iosUtils.elementIsDisplayed(loginFormButton, short_element_find);
        iosUtils.clickingOnElement(loginFormButton);
        iosUtils.wait(2);

    }












}
