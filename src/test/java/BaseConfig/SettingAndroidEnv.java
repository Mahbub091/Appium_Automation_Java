package BaseConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
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


        //run appium server automatically
        service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Md. Mahbubur. Rahman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options ();
        options.setPlatformName("android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Google Pixel 6");
        options.setApp(System.getProperty("user.dir") + "/apps/MyDemoAppRN.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        System.out.println("Starting Android App through APPIUM 2.0 Server");

        return driver;
    }

    @AfterTest
    public void closeApp() {
        driver.quit();
        System.out.println("Test Execution completed successfully");
    }


}
