package TestCases;

import BaseConfig.SettingAndroidEnv;
import PageManagement.HomePage;
import Utility.TestUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AndroidTestAutomation  extends SettingAndroidEnv {

    @Test (testName = "Test01", description = " Android App Automation")
    public void test01() {

        TestUtils testutils = new TestUtils(driver);
        HomePage homePage = new HomePage(driver);
        testutils.wait(2);

        homePage.clickingOnAppElement();
    }
}
