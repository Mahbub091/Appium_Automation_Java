package android.PageObject;

import Utility.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    public AndroidDriver driver;

    TestUtils testUtils;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        testUtils = new TestUtils(driver);
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Home-screen\"]/android.view.ViewGroup/android.widget.ImageView[1]")
    WebElement robotIcon;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Home-screen\"]/android.view.ViewGroup/android.widget.TextView[2]")
    WebElement demoText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Home\"]/android.widget.TextView[1]")
    WebElement homeMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Webview\"]/android.widget.TextView[1]")
    WebElement webView;

    @AndroidFindBy(accessibility = "Login")
    WebElement login;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Forms\"]/android.widget.TextView[1]")
    WebElement forms;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Swipe\"]/android.widget.TextView[1]")
    WebElement swipe;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Drag\"]/android.widget.TextView[1]")
    WebElement drag;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    WebElement loginMenuHeader;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-login-container\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement loginSectionButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement signUpSectionButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")
    WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement signUpButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    WebElement loginEmailInputField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    WebElement loginPasswordInputField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    WebElement signUpEmailInputField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    WebElement signUpPasswordInputField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-repeat-password\"]")
    WebElement signUpRepeatPasswordInputField;


    /**
     * We wil create our functions here.
     */

    public void verifyingNavigationToHomePage(){
        testUtils.elementIsDisplayed(robotIcon, 60);
        testUtils.verifyText(demoText, "Demo app for the appium-boilerplate");
        testUtils.clickingOnElement(demoText);
    }

    public void validatingWebViewMenu() {
        testUtils.wait(2);
        testUtils.elementIsDisplayed(webView, 60);
        testUtils.verifyText(webView, "\uDB81\uDD9F");
        testUtils.clickingOnElement(webView);
    }

    public void validatingLoginMenu() {
        testUtils.elementIsDisplayed(login, 60);
        testUtils.clickingOnElement(login);
        testUtils.wait(1);
    }

    public void validatingFormsMenu() {
        testUtils.elementIsDisplayed(forms, 60);
        testUtils.verifyText(forms, "\uDB80\uDFEB");
        testUtils.clickingOnElement(forms);
    }

    public void validatingSwipeMenu() {
        testUtils.elementIsDisplayed(swipe, 60);
        testUtils.verifyText(swipe, "\uDB82\uDD3C");
        testUtils.clickingOnElement(swipe);
    }

    public void validatingDragMenu() {
        testUtils.elementIsDisplayed(drag, 60);
        testUtils.verifyText(drag, "\uDB80\uDDDB");
        testUtils.clickingOnElement(drag);
    }

    public void validatingHomeMenu() {
        testUtils.elementIsDisplayed(homeMenu, 60);
        testUtils.verifyText(homeMenu, "Home");
        testUtils.clickingOnElement(homeMenu);
    }

    public void validatingLoginPageContent () {
        testUtils.elementIsDisplayed(loginMenuHeader,60);
        testUtils.verifyText(loginMenuHeader, "Login / Sign up Form");
        testUtils.verifyText(loginSectionButton, "Login");
        testUtils.elementIsDisplayed(signUpSectionButton, 60);
        testUtils.verifyText(signUpSectionButton, "Sign up");
        testUtils.clickingOnElement(signUpSectionButton);
        testUtils.clickingOnElement(loginSectionButton);

        testUtils.enterText(loginEmailInputField, "mahbub");
        testUtils.enterText(loginPasswordInputField, "1234");
        testUtils.clickingOnElement(loginButton);

        testUtils.wait(pause_Short);
    }

    public void userSignUp () {
        testUtils.clickingOnElement(signUpSectionButton);
        testUtils.elementIsDisplayed(signUpEmailInputField, 60);
        testUtils.deleteInput(signUpEmailInputField);
        testUtils.enterText(signUpEmailInputField, "mahbubasr091@gmail.com");
        testUtils.elementIsDisplayed(signUpPasswordInputField, 60);
        testUtils.deleteInput(signUpPasswordInputField);
        testUtils.enterText(signUpPasswordInputField, "12345678");
        testUtils.elementIsDisplayed(signUpRepeatPasswordInputField, 60);
        testUtils.deleteInput(signUpRepeatPasswordInputField);
        testUtils.enterText(signUpRepeatPasswordInputField, "12345678");
        testUtils.elementIsDisplayed(signUpButton, 60);
        testUtils.clickingOnElement(signUpButton);
    }
}
