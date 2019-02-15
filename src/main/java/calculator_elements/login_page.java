package main.java.calculator_elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class login_page {

    private static MobileElement element = null;

    public static MobileElement HomeAlertOk_button(AndroidDriver<MobileElement> driver) {
        element = driver.findElementByAccessibilityId("OK, THANKS");
        return element;
    }

    public static MobileElement UserName_text(AndroidDriver<MobileElement> driver) {
        element = driver.findElementByXPath("//android.webkit.WebView[@content-desc='Ionic App']/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
        return element;
    }

    public static MobileElement Password_text(AndroidDriver<MobileElement> driver) {
        element = driver.findElementByXPath("/android.webkit.WebView[@content-desc=\"Ionic App\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
        return element;
    }

    public static MobileElement SignIn_button(AndroidDriver<MobileElement> driver) {
        element = driver.findElementByAccessibilityId("SIGN IN");
        return element;
    }

    public static MobileElement SignIn1_button(AndroidDriver<MobileElement> driver) {
        element = driver.findElementByXPath("//android.widget.Button[@content-desc=\"SIGN IN \"]");
        return element;
    }
}