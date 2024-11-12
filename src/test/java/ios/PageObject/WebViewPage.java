package ios.PageObject;

import Utility.iOSTestUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import java.time.Duration;

public class WebViewPage {

    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;

    public WebViewPage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        iosUtils = new iOSTestUtils(iosDriver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"WebView\"]")
    WebElement webViewMenu;

    /**
     * We wil create our functions here.
     */

    public void text () {


    }
}
