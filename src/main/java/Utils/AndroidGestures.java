package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AndroidGestures extends AppiumUtils {

    public AndroidDriver driver;

    public AndroidGestures(AndroidDriver driver){

        this.driver = driver;

    }

      /*
        Actions associated with Native App
     */

    public void longPressAction(WebElement element){

        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), "duration", 2000));

    }

    public void scrollToEndAction(){

        boolean canScrollMore;

        do{
            canScrollMore   = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);

    }

    public void scrollDownVerySlightly(){

        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 10, "top", 10, "width", 200, "height", 200,
                "direction", "down",
                "percent", 0.25
        ));

    }

    public void scrollToBeginning(){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollToBeginning(10)"));

    }

    public void scrollTillElement(String text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

    }

    public void swipeTillElement(WebElement element, String direction, double percentage, int speed){

        //Swiping code
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
                        "direction", direction, "percent", 0.75, "speed", 1500));

    }

    public void DragDropAction(WebElement element, int x, int y){

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y
        ));

    }


    /*
        Misc. Methods
     */


}
