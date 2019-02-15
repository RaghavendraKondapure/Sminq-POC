package test.java;

import org.testng.annotations.Test;
import reinvent_utility.AndroidBaseUtil;
import genralized_utillity.Log4j.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;


public class Calculator extends AndroidBaseUtil {

    protected static AndroidDriver driver;
    public static final int LAUNCH_SLEEP = 1000;

    @Test
    public static void calculator_test() throws IOException, InterruptedException

    {

           /* DesiredCapabilities capabilities = new DesiredCapabilities();
            Log.info("Creating the automation session");
            capabilities.setCapability("deviceName", "Nexus 5X MArshmallow");
            capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
            capabilities.setCapability("appPackage", "com.android.calculator2");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability("newCommandTimeout", 500);*/

            Log.startTestCase("Starting test case for calculator");

            Log.info("selecting the digit");
            driver.findElementById("com.android.calculator2:id/digit_5").click();
            Thread.sleep(LAUNCH_SLEEP);


            Log.info("clicking on button");
            driver.findElementByAccessibilityId("times").click();

            Log.info("selecting the digit");
            driver.findElementById("com.android.calculator2:id/digit_2").click();

            Log.info("Clicking on equals button");
            driver.findElementByAccessibilityId("equals").click();
            driver.findElementById("com.android.calculator2:id/formula").getText();
         }

}



