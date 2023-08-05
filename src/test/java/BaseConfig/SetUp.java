package BaseConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetUp {

    public AndroidDriver driver;


    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options ();
        options.setPlatformName("android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Google Pixel 6");
        options.setApp(System.getProperty("user.dir") + "/apps/MyDemoAppRN.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        return driver;
    }

    @AfterTest
    public void closeApp() {
        driver.quit();
    }


}
