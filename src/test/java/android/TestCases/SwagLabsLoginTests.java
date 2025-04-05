package android.TestCases;

import BaseConfig.ConfigReader;
import BaseConfig.SettingAndroidEnv;
import Utility.TestUtils;
import android.PageObject.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagLabsLoginTests extends SettingAndroidEnv {
    LoginPage loginPage;
    TestUtils test;
    ConfigReader configReader;
    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
        test = new TestUtils(driver);
        configReader= new ConfigReader();
    }

    @Test(testName = "Wrong Email Login Test", description = "Validating The User Login for Wrong Email")
    public void test01() {
        loginPage.wrongEmailLogin();
        loginPage.userLogOut();
    }

    @Test(testName = "Successful Login Test", description = "Validating The User Login")
    public void test02() {
        loginPage.userSuccessfulLogin(configReader.validUserName(), configReader.validPassword());
        loginPage.userLogOut();
    }
}
