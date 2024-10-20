package ios.PageObject;

import Utility.iOSTestUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwipePage {


    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;

    public SwipePage(IOSDriver iosDriver) {
        PageFactory.initElements(iosDriver, this);
        iosUtils = new iOSTestUtils(iosDriver);

    }

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Swipe\"]")
    WebElement swipeMenu;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe horizontal\"]")
    WebElement swipeMenuHeaderText;

    /**
     * We wil create our functions here.
     */

    public void text () {


    }
}
