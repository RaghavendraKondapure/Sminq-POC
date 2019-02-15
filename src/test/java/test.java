package test.java;

import org.testng.annotations.Test;
import reinvent_actions.Action;
import reinvent_elements.login_page;
import reinvent_utility.AndroidBaseUtil;
import genralized_utillity.Log4j.Log;


import java.io.IOException;

public class test extends AndroidBaseUtil {

    public static final int LAUNCH_SLEEP = 1000;


    @Test
    public void Login_test() throws IOException, InterruptedException

    {
        Log.startTestCase("Starting test case for the login into application");

        Log.info("dismissing alert");
        login_page.HomeAlertOk_button(driver).click();
        Thread.sleep(LAUNCH_SLEEP);

        Log.info("entering value of username");
        login_page.UserName_text(driver).sendKeys("sgomes");
        Thread.sleep(LAUNCH_SLEEP);

        Log.info("entering value of Password");
        login_page.Password_text(driver).sendKeys("mobTest123!");
        Thread.sleep(LAUNCH_SLEEP);

        Action.Handlekeyboard();
        Thread.sleep(LAUNCH_SLEEP);

        Log.info("Clicking on sing in button");
        login_page.SignIn_button(driver).click();
        Thread.sleep(LAUNCH_SLEEP);
    }
}
