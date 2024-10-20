package ios.PageObject;

import Utility.iOSTestUtils;
import com.github.javafaker.Faker;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        PageFactory.initElements(iosDriver, this);
        iosUtils = new iOSTestUtils(iosDriver);

    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign up\"]")
    WebElement signUpFormButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login\"]")
    WebElement loginFormButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Login\"]")
    WebElement loginMenu;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login / Sign up Form\"]")
    WebElement loginMenuHeaderText;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"input-email\"]")
    WebElement loginEmailField;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"input-password\"]")
    WebElement loginPasswordField;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"LOGIN\"]")
    WebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"input-email\"]")
    WebElement signUpFormEmail;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"input-password\"]")
    WebElement signUpFormPassword;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"input-repeat-password\"]")
    WebElement signUpFormConfirmPassword;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN UP\"]")
    WebElement signUpButton;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[3]")
    WebElement signUpCompleteButton;


    /**
     * We wil create our functions here.
     */

    public void populatingTheLoginForm () {
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
        iosUtils.elementIsDisplayed(signUpCompleteButton, short_element_find);
        iosUtils.clickingOnElement(signUpCompleteButton);

        iosUtils.clickingOnElement(loginFormButton);
        iosUtils.wait(2);

    }












}
