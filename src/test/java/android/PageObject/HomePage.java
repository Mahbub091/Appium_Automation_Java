package android.PageManagement;

import BaseConfig.SettingAndroidEnv;
import android.Utility.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SettingAndroidEnv {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    WebDriver driver;

    public static AndroidDriver andro;

    TestUtils testUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "(//android.widget.ImageView) [5]")
    WebElement tshirtBox;

    @FindBy(xpath = "(//android.widget.TextView) [1]")
    WebElement tshirtText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
    WebElement menuButton;

    @FindBy(linkText = "Catalog")
    WebElement webviewMenu;

    @iOSXCUITFindBy(accessibility = "messageSaveBtn")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='messageSaveBtn']")




    public void clickingOnAppElement(){
        testUtils.elementIsDisplayed(tshirtBox, 60);
        testUtils.clickingOnElement(tshirtBox);
        testUtils.wait(1);
        testUtils.verifyText(tshirtText, "Sauce Labs Backpack");

    }

    public void menu() {
        testUtils.elementIsDisplayed(menuButton, 60);
        testUtils.wait(pause_Short);
        testUtils.clickingOnElement(menuButton);
        testUtils.wait(pause_Short);
        testUtils.clickingOnElement(menuButton);
        testUtils.wait(pause_Short);
        driver.findElement(AppiumBy.accessibilityId("longpress reset app")).isDisplayed();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).click(text());"));
        andro.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
