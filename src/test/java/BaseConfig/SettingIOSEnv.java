package BaseConfig;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingIOSEnv {
    public IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public IOSDriver setup() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(System.getProperty("user.dir") + "/reports/AppiumLog.txt"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(60))
                .build();

        service.start();

        // Desired capabilities for iOS
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 11 Pro Max")
                .setPlatformVersion("17.4")
                .setBundleId("org.reactjs.native.example.wdioDemoApp")
                .setNoReset(false);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println("Starting iOS App through Appium Server");

        return driver;
    }

    @AfterClass
    public void closeApp() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
