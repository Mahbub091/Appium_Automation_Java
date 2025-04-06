package ios.PageObject;

import Utility.iOSTestUtils;
import com.github.javafaker.Faker;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductsPage {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;

    public ProductsPage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        iosUtils = new iOSTestUtils(iosDriver);
    }

    @iOSXCUITFindBy(accessibility = "assets/src/img/swag-labs-logo.png")
    WebElement logo;

    @iOSXCUITFindBy(accessibility = "test-Toggle")
    WebElement userToggleIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"test-Item title\" and @label=\"Sauce Labs Backpack\"]")
    WebElement sauceLabsBackpack;

    @iOSXCUITFindBy(accessibility = "test-Menu")
    WebElement menuButton;

    @iOSXCUITFindBy(accessibility = "test-RESET APP STATE")
    WebElement resetAppStateButton;

    @iOSXCUITFindBy(accessibility = "test-LOGOUT")
    WebElement logoutButton;


    /**
     * We wil create our functions here.
     */

    public void userLogout() {
        iosUtils.elementIsDisplayed(menuButton, short_element_find);
        iosUtils.clickingOnElement(menuButton);
        iosUtils.elementIsDisplayed(resetAppStateButton, short_element_find);
        iosUtils.clickingOnElement(resetAppStateButton);
        iosUtils.waitForElementInVisibility(menuButton, short_element_find);
        iosUtils.clickingOnElement(menuButton);
        iosUtils.elementIsDisplayed(logoutButton, short_element_find);
        iosUtils.clickingOnElement(logoutButton);
        iosUtils.waitForElementInVisibility(logoutButton, short_element_find);
    }




}
