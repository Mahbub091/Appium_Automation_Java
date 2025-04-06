package ios.TestCases;

import BaseConfig.SettingIOSEnv;
import Utility.iOSTestUtils;
import ios.PageObject.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserLogin extends SettingIOSEnv {
    iOSTestUtils testUtils;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
        loginPage= new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        testUtils = new iOSTestUtils(driver);

    }

    @Test(testName = "UserSuccessLogin", description = "Verify All Menus To Be Active")
    public void test02() {
        loginPage.userLogin();
        productsPage.userLogout();
        loginPage.validatingSuccessLogout();
    }

    @Test(testName = "UserWrongEmailLogin", description = "Verify Error Message")
    public void test01() {
        loginPage.wrongEmailLogin();
    }

    @Test(testName = "UserWrongPasswordLogin", description = "Verify Wrong Password Error Message")
    public void test03() {
        loginPage.wrongPasswordLogin();
    }

    @Test(testName = "UserNamrEmptyLogin", description = "Verify Login Attempt Without Username Credentials")
    public void test04() {
        loginPage.emptyUserNameLogin();
    }

    @Test(testName = "UserPasswordEmptyLogin", description = "Verify Login Attempt Without Password Credentials")
    public void test05() {
        loginPage.emptyPasswordLogin();
    }

    @Test(testName = "UserLockedOutLogin", description = "Verify Locked Out User Error Message")
    public void test06() {
        loginPage.lockedOutUserLogin();
    }

    @Test(testName = "UserProblemUserLogin", description = "Verify Problem User Error Message")
    public void test07() {
        loginPage.problemUserLogin();
    }


}
