package android.PageObject;

import Utility.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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


    @FindBy(xpath = "//android.widget.TextView[@text='contect']")
    WebElement contentMenu;







//        driver.findElement(By.xpath("//android.widget.TextView[@text='Content']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Graphics']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Media']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='NFC']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='OS']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Text']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));


    public void androidGoBack() {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public void verifyingAccessibilityMenu(){
        testUtils.elementIsDisplayed(accessibilityMenu, 60);
        testUtils.verifyText(accessibilityMenu, "Accessibility");
        testUtils.clickingOnElement(accessibilityMenu);
        testUtils.pressBack();

    }
}
