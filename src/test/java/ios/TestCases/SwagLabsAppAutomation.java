package ios.TestCases;

import BaseConfig.SettingIOSEnv;
import Utility.iOSTestUtils;
import ios.PageObject.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagLabsAppAutomation extends SettingIOSEnv {
    HomePage homePage;
    iOSTestUtils testUtils;
    WebViewPage webViewPage;
    LoginPage loginPage;
    FormsPage formsPage;
    SwipePage swipePage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        webViewPage = new WebViewPage(driver);
        loginPage= new LoginPage(driver);
        formsPage = new FormsPage(driver);
        swipePage = new SwipePage(driver);
        testUtils = new iOSTestUtils(driver);

    }

    @Test(testName = "MenusVerification", description = "Verify All Menus To Be Active")
    public void test01() {
        homePage.verifyingMenusToBeActive();
    }

    @Test(testName = "VerifyHomeMenu", description = "Verify Assets On Home Page")
    public void test02() {
        homePage.verifyingAccessibilityMenu();
        homePage.validatingTextOnPage();
        homePage.verifyingAccessibilityMenu();
        homePage.validatingTextOnPage();
    }

    @Test(testName = "WrongEmailValidation", description = "Verify Text On Home Page")
    public void test03() {
        loginPage.attemptingIncompleteEmailLogin();
    }

    @Test(testName = "WrongPasswordValidation", description = "User Inserts Wrong Password")
    public void test04() {
        loginPage.attemptingWrongPasswordLogin();
    }

    @Test(testName = "RandomEmailValidation", description = "User Inserts Not Registered Email")
    public void test05() {
        loginPage.attemptingRandomEmailLogin();
    }

    @Test(testName = "ValidUserSignUp", description = "User Tries to SignUp Using Valid Details")
    public void test010() {
        loginPage.populatingTheSignUpForm();
    }
}
