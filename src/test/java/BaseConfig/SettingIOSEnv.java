package BaseConfig;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingIOSEnv {
    public IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeTest
    public IOSDriver setup() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(System.getProperty("user.dir") + "/reports/Logs/AppiumLog.txt"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(300))
                .build();

        service.start();

        // Desired capabilities for iOS
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "15.0");
        capabilities.setCapability("deviceName", "iPhone 12");
        capabilities.setCapability("automationName", AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/ios.ipa");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);

        System.out.println("Starting iOS App through Appium Server");

        return driver;
    }

    @AfterTest
    public void closeApp() {
        driver.quit();
        service.stop();
    }
}