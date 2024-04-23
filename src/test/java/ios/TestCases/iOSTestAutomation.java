package ios.TestCases;

import BaseConfig.SettingIOSEnv;
import Utility.iOSTestUtils;
import ios.PageObject.AppleHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iOSTestAutomation extends SettingIOSEnv {
    AppleHomePage samplePage;
    iOSTestUtils testUtils;

    @BeforeClass
    public void setUp() {
        samplePage = new AppleHomePage(driver);
        testUtils = new iOSTestUtils(driver);

    }

    @Test(testName = "Test01", description = " Verifying The Menus")
    public void test01() {
        testUtils.wait(1);
        samplePage.verifyingAccessibilityMenu();
    }
}
