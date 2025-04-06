package android.TestCases;

import BaseConfig.ConfigReader;
import BaseConfig.SettingAndroidEnv;
import Utility.TestUtils;
import android.PageObject.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends SettingAndroidEnv {
    LoginPage loginPage;
    TestUtils test;
    ConfigReader configReader;
    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
        test = new TestUtils(driver);
        configReader= new ConfigReader();
    }

    @Test(testName = "Successful Login Test", description = "Validating The User Login")
    public void test01() {
        loginPage.userSuccessfulLogin(configReader.validUserName(), configReader.validPassword());
        loginPage.userLogOut();
    }

    @Test(testName = "Wrong Email Login Test", description = "Validating The User Login for Wrong Email")
    public void test02() {
        loginPage.wrongEmailLogin();
    }

    @Test(testName = "WrongPasswordLogin", description = "Validating The User Login with Wrong Password")
    public void test03() {
        loginPage.wrongPasswordLogin();
    }

    @Test(testName = "BlankEmailTest", description = "Validating user Login Attempt with Blank Email")
    public void test04() {
        loginPage.blankEmailValidation();
    }

    @Test(testName = "BlankPasswordTest", description = "Validating user Login Attempt With Blank Password")
    public void test05() {
        loginPage.blankPasswordValidation();
    }

    @Test(testName = "BlockedUserTest", description = "Validating Block User Login Attempt")
    public void test06() {
        loginPage.blockedUserValidation();
    }
}
