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
    public void test01() {
        loginPage.userLogin();
    }


}
