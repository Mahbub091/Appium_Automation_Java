package android.TestCases;

import BaseConfig.ConfigReader;
import BaseConfig.SettingAndroidEnv;
import Utility.TestUtils;
import android.PageObject.SwagLabsHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagLabsLoginTests extends SettingAndroidEnv {
    SwagLabsHomePage homePage;
    TestUtils test;
    ConfigReader configReader;
    @BeforeClass
    public void setUp() {
        homePage = new SwagLabsHomePage(driver);
        test = new TestUtils(driver);
        configReader= new ConfigReader();
    }

    @Test(testName = "Successful Login Test", description = "Validating The User Login")
    public void test01() {
        homePage.userSuccessfulLogin(configReader.validUserName(), configReader.validPassword());
        homePage.userLogOut();

    }
}
