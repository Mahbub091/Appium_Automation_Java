package TestCases;

import BaseConfig.SetUp;
import org.testng.annotations.Test;

public class AndroidTestAutomation  extends SetUp {

    @Test
    public void test01() throws InterruptedException {
        System.out.println("Starting Android App through APPIUM 2.0 Server");
        Thread.sleep(4000);

        System.out.println("Test Execution completed successfully");
    }
}
