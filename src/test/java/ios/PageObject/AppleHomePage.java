package ios.PageObject;

import Utility.iOSTestUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppleHomePage {
    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    iOSTestUtils iosUtils;

    public AppleHomePage(IOSDriver iosDriver) {
        PageFactory.initElements(iosDriver, this);
        iosUtils = new iOSTestUtils(iosDriver);

    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
    WebElement accessibilityMenu;


    /**
     * We wil create our functions here.
     */

    public void verifyingAccessibilityMenu(){
    }
}
