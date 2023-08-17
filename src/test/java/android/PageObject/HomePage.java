package android.PageObject;

import Utility.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    private AndroidDriver driver;

    TestUtils testUtils;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);

    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
    WebElement accessibilityMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='Animation']")
    WebElement animationMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='App']")
    WebElement appMenu;


    @FindBy(xpath = "//android.widget.TextView[@text='Content']")
    WebElement contentMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='Graphics']")
    public WebElement graphicsMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='Media']")
    public WebElement mediaMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='NFC']")
    public WebElement nfcMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='OS']")
    public WebElement osMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public WebElement preferenceMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='Text']")
    public WebElement textMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    public WebElement viewsMenu;


    /**
     * We wil create our functions here.
     */

    public void verifyingAccessibilityMenu(){
        testUtils.elementIsDisplayed(accessibilityMenu, 60);
        testUtils.verifyText(accessibilityMenu, "Accessibility");
        testUtils.clickingOnElement(accessibilityMenu);
        testUtils.pressBack();
    }
}
