package ios.PageObject;

import BaseConfig.ConfigReader;
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
    ProductsPage productsPage;
    ConfigReader configReader;

    public LoginPage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        iosUtils = new iOSTestUtils(iosDriver);
        productsPage = new ProductsPage(iosDriver);
        configReader = new ConfigReader();
    }

    @iOSXCUITFindBy(accessibility = "assets/src/img/swag-labs-logo.png")
    WebElement logo;

    @iOSXCUITFindBy(accessibility = "test-Username")
    WebElement userNameInput;

    @iOSXCUITFindBy(accessibility = "test-Password")
    WebElement passwordInput;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "test-Error message")
    WebElement errorMessage;


    /**
     * We wil create our functions here.
     */

public void userLogin() {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, configReader.validUserName());
        iosUtils.wait(1);
    iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, configReader.validUserName());
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, configReader.validPassword());
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(loginButton, short_element_find);
        iosUtils.elementIsDisplayed(productsPage.sauceLabsBackpack, short_element_find);
        iosUtils.verifyText(productsPage.sauceLabsBackpack, "Sauce Labs Backpack");
    }

    public void wrongEmailLogin () {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, faker.internet().emailAddress());
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, configReader.validPassword());
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(logo, short_element_find);
        iosUtils.elementIsDisplayed(errorMessage, short_element_find);
        iosUtils.verifyText(errorMessage, "Username and password do not match any user in this service.");
    }

    public void validatingSuccessLogout () {
    iosUtils.elementIsDisplayed(loginButton, long_element_find);
    iosUtils.verifyText(loginButton, "LOGIN");
    }

    public void wrongPasswordLogin () {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, configReader.validUserName());
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, faker.internet().password());
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(logo, short_element_find);
        iosUtils.elementIsDisplayed(errorMessage, short_element_find);
        iosUtils.verifyText(errorMessage, "Username and password do not match any user in this service.");
    }

    public void emptyUserNameLogin () {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, "");
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, configReader.validPassword());
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(logo, short_element_find);
        iosUtils.elementIsDisplayed(errorMessage, short_element_find);
        iosUtils.verifyText(errorMessage, "Username is required");
    }

    public void emptyPasswordLogin () {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, configReader.validUserName());
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, "");
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(logo, short_element_find);
        iosUtils.elementIsDisplayed(errorMessage, short_element_find);
        iosUtils.verifyText(errorMessage, "Password is required");
    }

    public void lockedOutUserLogin () {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, configReader.locked_out_user());
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, configReader.validPassword());
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(logo, short_element_find);
        iosUtils.elementIsDisplayed(errorMessage, short_element_find);
        iosUtils.verifyText(errorMessage, "Sorry, this user has been locked out.");
    }

    public void problemUserLogin () {
        iosUtils.elementIsDisplayed(logo, short_element_find);
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.enterText(userNameInput, configReader.problem_user());
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, configReader.validPassword());
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.waitForElementInVisibility(logo, short_element_find);
        iosUtils.elementIsDisplayed(errorMessage, short_element_find);
        iosUtils.verifyText(errorMessage, "Sorry, this user has been locked out.");
    }




}
