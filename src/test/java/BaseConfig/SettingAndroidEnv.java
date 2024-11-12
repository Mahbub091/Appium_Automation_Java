package BaseConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingAndroidEnv {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                //.withAppiumJS(new File("C:\\Users\\Md. Mahbubur. Rahman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                //.usingDriverExecutable(new File("PATH TO YOUR NODE.JS"))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(System.getProperty("user.dir") + "/reports/Logs/AppiumLog.txt"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(300))
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("emulator-5544");
        options.setApp(System.getProperty("user.dir") + "/apps/WDioApp.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Initialize PageFactory for @AndroidFindBy annotations
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        System.out.println("Starting Android App Automation through APPIUM 2.0 Server");

        return driver;
    }

    @AfterTest
    public void closeApp() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
