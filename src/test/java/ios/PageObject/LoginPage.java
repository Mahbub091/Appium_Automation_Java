package ios.PageObject;

import Utility.iOSTestUtils;
import com.github.javafaker.Faker;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    Faker faker = new Faker();

    int pause_Short = 1;
    int pause_long = 2;
    int pause_extended = 3;

    int short_element_find = 10;
    int long_element_find = 20;
    int extended_element_find = 30;

    iOSTestUtils iosUtils;
    ProductsPage productsPage;

    public LoginPage(IOSDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
        iosUtils = new iOSTestUtils(iosDriver);
        productsPage = new ProductsPage(iosDriver);
    }

    @iOSXCUITFindBy(accessibility = "test-Username")
    WebElement userNameInput;

    @iOSXCUITFindBy(accessibility = "test-Password")
    WebElement passwordInput;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    WebElement loginButton;


    /**
     * We wil create our functions here.
     */

public void userLogin() {
        iosUtils.elementIsDisplayed(userNameInput, short_element_find);
        iosUtils.clickingOnElement(userNameInput);
        iosUtils.wait(2);
        iosUtils.enterText(userNameInput, "standard_user");
        iosUtils.elementIsDisplayed(passwordInput, short_element_find);
        iosUtils.clickingOnElement(passwordInput);
        iosUtils.enterText(passwordInput, "secret_sauce");
        iosUtils.elementIsDisplayed(loginButton, short_element_find);
        iosUtils.clickingOnElement(loginButton);
        iosUtils.elementIsDisplayed(productsPage.sauceLabsBackpack, short_element_find);
        iosUtils.verifyText(productsPage.sauceLabsBackpack, "Sauce Labs Backpack2");
    }




}
