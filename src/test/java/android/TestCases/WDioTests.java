package android.TestCases;

import BaseConfig.ConfigReader;
import BaseConfig.SettingAndroidEnv;
import Utility.TestUtils;
import android.PageObject.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WDioTests extends SettingAndroidEnv {
    HomePage homePage;
    TestUtils test;
    ConfigReader configReader;
    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        test = new TestUtils(driver);
        configReader= new ConfigReader();
    }

    @Test (testName = "UserNavigatesToMenus", description = " Verifying The Menus")
    public void test01() {
        test.wait(1);
        homePage.verifyingNavigationToHomePage();
        homePage.validatingWebViewMenu();
        homePage.validatingLoginMenu();
        homePage.validatingFormsMenu();
        homePage.validatingSwipeMenu();
        homePage.validatingDragMenu();
        homePage.validatingHomeMenu();
    }

    @Test (testName = "ValidatingLoginSuccess", description = "Validating Login Sections")
    public void test02() {
        homePage.validatingLoginMenu();
        homePage.validatingLoginPageContent();
    }

    @Test (testName = "ValidatingUserSuccessSignUp", description = "Validating Success Sign Up Section")
    public void test03() {
    homePage.userSignUp();
    }
}
