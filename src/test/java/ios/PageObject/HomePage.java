package ios.PageObject;

import Utility.iOSTestUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import java.time.Duration;

public class HomePage {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;
    WebViewPage webViewPage;
    LoginPage loginPage;
    FormsPage formsPage;
    SwipePage swipePage;

    public HomePage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        webViewPage= new WebViewPage(iosDriver);
        loginPage= new LoginPage(iosDriver);
        formsPage = new FormsPage(iosDriver);
        swipePage = new SwipePage(iosDriver);
        iosUtils = new iOSTestUtils(iosDriver);
    }

    /*
    /*
     * Our Elements Will Be Stored Here.
     */

    //XCUIElementTypeOther[@name="Home"]

    @iOSXCUITFindBy(accessibility = "Home")
    WebElement homeMenu;

    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    WebElement homeScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"WEBDRIVER I/O Demo app for the appium-boilerplate\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"WEBDRIVER I/O Demo app for the appium-boilerplate\"]")
    WebElement homeMenuText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WEBDRIVER\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WEBDRIVER\"]")
    WebElement homeMenuHeaderText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Demo app for the appium-boilerplate\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Demo app for the appium-boilerplate\"]")
    WebElement homeMenuSubText;


    /**
     * We wil create our functions here.
     */

    public void verifyingMenusToBeActive () {
        iosUtils.elementIsDisplayed(webViewPage.webViewMenu, extended_element_find);
        iosUtils.clickingOnElement(webViewPage.webViewMenu);
        iosUtils.elementIsDisplayed(loginPage.loginMenu, short_element_find);
        iosUtils.clickingOnElement(loginPage.loginMenu);
        iosUtils.verifyText(loginPage.loginMenuHeaderText, "Login / Sign up Form");
        iosUtils.elementIsDisplayed(formsPage.formsMenu, extended_element_find);
        iosUtils.clickingOnElement(formsPage.formsMenu);
        iosUtils.assertText(formsPage.formsMenuHeaderText, "Form components");
        iosUtils.elementIsDisplayed(swipePage.swipeMenu, extended_element_find);
        iosUtils.clickingOnElement(swipePage.swipeMenu);
        iosUtils.verifyText(swipePage.swipeMenuHeaderText, "Swipe horizontal");
        iosUtils.elementIsDisplayed(this.homeMenu, extended_element_find);
        iosUtils.clickingOnElement(this.homeMenu);
        iosUtils.waitForElementInVisibility(swipePage.swipeMenuHeaderText, extended_element_find);
        iosUtils.verifyText(this.homeMenuHeaderText, "WEBDRIVER");
    }

    public void verifyingAccessibilityMenu(){
        iosUtils.elementIsDisplayed(homeScreen, extended_element_find);
        iosUtils.elementIsDisplayed(homeMenuHeaderText, long_element_find);
        iosUtils.assertText(homeMenuHeaderText, "WEBDRIVER");
        iosUtils.elementIsDisplayed(homeMenuSubText, short_element_find);
        iosUtils.assertText(homeMenuSubText, "Demo app for the appium-boilerplate");
    }

    public void validatingTextOnPage(){
        iosUtils.wait(1);
        iosUtils.elementIsDisplayed(homeMenuText, extended_element_find);
        iosUtils.verifyText(homeMenuText, "WEBDRIVER I/O Demo app for the appium-boilerplate");


    }
}
