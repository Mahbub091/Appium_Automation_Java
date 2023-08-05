package PageManagement;

import Utility.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    int time_out_max = 60;
    int time_out_min = 30;
    int pause_normal = 1;
    int pause_long = 2;
    int pause_extended = 3;

    WebDriver driver;

    TestUtils testUtils;

    Logger log = LogManager.getLogger("HomePage");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "(//android.widget.ImageView) [5]")
    WebElement tshirtBox;

    @FindBy(xpath = "(//android.widget.TextView) [1]")
    WebElement tshirtText;



    public void clickingOnAppElement(){
        testUtils.elementIsDisplayed(tshirtBox, time_out_min);
        testUtils.clickingOnElement(tshirtBox);
        testUtils.verifyText(tshirtText, "Sauce Labs Backpack");

    }




}
