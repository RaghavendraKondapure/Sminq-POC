package main.java.calculator_actions;

import io.appium.java_client.TouchAction;
import main.java.calculator_utility.AndroidBaseUtil;
import org.openqa.selenium.Dimension;

public class Action extends AndroidBaseUtil {

    /*
    ----> swipe function is used to swipe at all directions based on the co-ordinates passed to it
     */
    public static void swipe(int startx, int starty, int endx, int endy) {

        TouchAction test = new TouchAction(driver);
        //mention the X,Y offset and start and end points
        test.press(startx, starty).moveTo(endx, endy).release().perform();

    }

    /*
    ---->this function used to hide the keyboard if it appears while sending text to textbox
     */
    public static void Handlekeyboard() {

        boolean key = driver.isKeyboardShown();
        if (key == true) {
            driver.hideKeyboard();
        }
    }

    public static void swipevertical(double startpercentage, double endpercentage) {

        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.width / 2);
        int startpoint = (int) (size.getHeight() * startpercentage);
        int endpoint = (int) (size.getHeight() * endpercentage);

        TouchAction test = new TouchAction(driver);

        test.press(width, startpoint).moveTo(width, endpoint).release().perform();


    }

    public static void swipehorizontal(double startpercentage, double endpercentage) {

        Dimension size = driver.manage().window().getSize();
        int Height = (int) (size.height / 2);
        int startpoint = (int) (size.getHeight() * startpercentage);
        int endpoint = (int) (size.getHeight() * endpercentage);

        TouchAction test = new TouchAction(driver);

        test.press(startpoint, Height).moveTo(endpoint, Height).release().perform();


    }


}
