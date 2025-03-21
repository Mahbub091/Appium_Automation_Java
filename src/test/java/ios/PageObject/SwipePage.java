package ios.PageObject;

import Utility.iOSTestUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SwipePage {


    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;
    FormsPage formsPage;

    public SwipePage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        iosUtils = new iOSTestUtils(iosDriver);
        formsPage = new FormsPage(iosDriver);
    }

    @iOSXCUITFindBy(accessibility = "Swipe")
    WebElement swipeMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe horizontal\"]")
    WebElement swipeMenuHeaderText;

    /**
     * We wil create our functions here.
     */

    public void text () {
        iosUtils.swipe(300,590,152,590);
        iosUtils.swipe(300,590,152,590);
        iosUtils.swipe(300,590,152,590);
        iosUtils.swipe(300,590,152,590);
        iosUtils.swipe(300,590,152,590);
        iosUtils.swipe(150,590,300,590);
        iosUtils.swipe(150,590,300,590);
        iosUtils.swipe(150,590,300,590);
        iosUtils.swipe(150,590,300,590);
        iosUtils.swipe(150,590,300,590);

        iosUtils.clickingOnElement(formsPage.formsMenu);
        iosUtils.scrollToElement("Active");


    iosUtils.wait(2);

    }
}
