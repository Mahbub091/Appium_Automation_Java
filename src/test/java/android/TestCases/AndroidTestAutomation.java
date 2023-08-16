package android.TestCases;

import BaseConfig.SettingAndroidEnv;
import Utility.TestUtils;
import android.PageObject.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AndroidTestAutomation  extends SettingAndroidEnv {
    HomePage homePage;
    TestUtils test;
    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        test = new TestUtils(driver);
    }

    @Test (testName = "Test01", description = " Android App Automation")
    public void test01() {
        test.wait(1);
        homePage.verifyingAccessibilityMenu();



    }
}
