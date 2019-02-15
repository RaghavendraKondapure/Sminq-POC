package main.java.calculator_utility;

import genralized_utillity.Log4j.Log;
import genralized_utillity.Screenshot.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reinvent_hockey_app.AppVersion;
import reinvent_hockey_app.Download_APK;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*
--> Base class for android to set all desired capability
 */

public class AndroidBaseUtil {

    protected static AndroidDriver driver;
    //protected static RemoteWebDriver driver;
    protected static WebDriverWait wait;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";


    /*
    ------> Super setup will download latest .apk file from Hockey App
     */

    @BeforeSuite
    public void supersetup() throws IOException {

        //code to check internet/VPN connection

       /* Boolean connect = InternetAvailabilityChecker.isInternetAvailable();
        if (connect == true) {
            System.out.println(ANSI_GREEN + "\nConnected with Internet and VPN \n" + ANSI_RESET);

        }*/

        //calling method to download .apk
      /*  try {
            Download_APK.getAPKFromURL();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }


    //Before Class Annotation makes java function to run every time before a TestNG Test class
    @BeforeClass
    protected void CreateAppiumDriver() throws IOException, InterruptedException {


        try {

            //Setting up Desired Capability
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Nexus Android Oreo");
            capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
            capabilities.setCapability("appPackage", "com.android.calculator2");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability("newCommandTimeout", 500);



            //Relative Path to .apk file
          /*  final File classpath = new File(System.getProperty("user.dir"));
            final File appdir = new File(classpath, "src/test/resources/app/");
            //final File app = new File(appdir, AppVersion.getAPPTITLE() + ".apk");
            final File app = new File(appdir, "Reinvent.apk");
            capabilities.setCapability("app", app.getAbsolutePath());*/

            //Initializing driver object
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            //Initializing explicit wait object
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            wait = new WebDriverWait(driver, 10);

        } catch (Exception e) {

            Log.error("Found issue in Android Desired Capability");
            System.out.println(e);
        }
    }


    //After Class Annotation makes java function to run every time after a TestNG Test class
    @AfterSuite
    public void End() {
        //quit the driver
        driver.quit();
    }


    //Capture Screenshot for failed testCases
    @AfterMethod
    public void screenshotTest(ITestResult result) throws IOException {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                Screenshot.getScreenshot(driver, result.getName());
            }
        } catch (Exception e) {
            Log.error("Screenshot method Issue");
            System.out.println(e);
        }
    }
}

