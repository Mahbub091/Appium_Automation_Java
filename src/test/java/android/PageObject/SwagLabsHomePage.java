package android.PageObject;

import BaseConfig.ConfigReader;
import Utility.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsHomePage {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    public AndroidDriver driver;

    TestUtils testUtils;

    ConfigReader configReader;

    public SwagLabsHomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        testUtils = new TestUtils(driver);
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @AndroidFindBy(accessibility = "test-Username")
    WebElement userNameField;

    @AndroidFindBy(accessibility = "test-Password")
    WebElement userPasswordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")
    WebElement loginButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")
    WebElement loginPageHeader;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement productsText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement userMenu;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ALL ITEMS\"]/android.widget.TextView")
    WebElement allItemsMenu;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Close\"]/android.widget.ImageView")
    WebElement menuCloseButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-RESET APP STATE\"]/android.widget.TextView")
    WebElement resetAppMenu;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]/android.widget.TextView")
    WebElement userLogoutButton;



    /**
     * We wil create our functions here.
     */

    public void userSuccessfulLogin (String userName, String userPassword) {
        testUtils.elementIsDisplayed(userNameField, long_element_find);
        testUtils.enterText(userNameField, userName);
        testUtils.elementIsDisplayed(userPasswordField, long_element_find);
        testUtils.enterText(userPasswordField, userPassword);
        testUtils.elementIsDisplayed(loginButton, long_element_find);
        testUtils.clickingOnElement(loginButton);
        testUtils.elementIsDisplayed(loginPageHeader, long_element_find);
        testUtils.elementIsDisplayed(productsText, long_element_find);
        testUtils.verifyText(productsText, "PRODUCTS");
        testUtils.elementIsDisplayed(userMenu, long_element_find);
        testUtils.clickingOnElement(userMenu);
        testUtils.elementIsDisplayed(allItemsMenu, long_element_find);
        testUtils.assertText(allItemsMenu, "ALL ITEMS");
        testUtils.elementIsDisplayed(menuCloseButton, long_element_find);
        testUtils.clickingOnElement(menuCloseButton);
        testUtils.waitForElementInVisibility(allItemsMenu, long_element_find);
    }

    public void userLogOut () {
        testUtils.elementIsDisplayed(userMenu, long_element_find);
        testUtils.clickingOnElement(userMenu);
        testUtils.elementIsDisplayed(resetAppMenu, long_element_find);
        testUtils.clickingOnElement(resetAppMenu);
        testUtils.elementIsDisplayed(userMenu, long_element_find);
        testUtils.clickingOnElement(userMenu);
        testUtils.elementIsDisplayed(userLogoutButton, long_element_find);
        testUtils.clickingOnElement(userLogoutButton);
        testUtils.waitForElementInVisibility(userMenu, long_element_find);
        testUtils.elementIsDisplayed(userNameField, long_element_find);
    }
}
