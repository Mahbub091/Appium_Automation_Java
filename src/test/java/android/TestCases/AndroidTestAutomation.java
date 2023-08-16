package TestCases;

import BaseConfig.SettingAndroidEnv;
import Utility.TestUtils;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AndroidTestAutomation  extends SettingAndroidEnv {

    @Test (testName = "Test01", description = " Android App Automation")
    public void test01() {
        TestUtils test = new TestUtils(driver);
        test.wait(1);
        String title = driver.findElements(By.xpath("//android.widget.TextView [1]")).get(0).getText();
        System.out.println(title);
        driver.findElement(By.id("android:id/text1")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK)); //Navigate back from current screen
        test.wait(1);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Animation']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Content']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Graphics']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Media']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='NFC']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='OS']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Text']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));


    }
}
