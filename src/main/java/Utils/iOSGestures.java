package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class iOSGestures extends AppiumUtils {

    IOSDriver driver;

    public iOSGestures(IOSDriver driver){

        this.driver = driver;

    }

    /*
        Actions associated with Native App
     */


    public void longPressAction(WebElement element){

        ((JavascriptExecutor) driver).executeScript("mobile:touchAndHold", ImmutableMap.of("element", ((RemoteWebElement) element).getId(), "duration", 5));

    }


    public void scrollTillElement(WebElement element){

        ((JavascriptExecutor)driver).executeScript("mobile:scroll", ImmutableMap.of("element", ((RemoteWebElement)element).getId(), "direction", "down"));

    }

    public void swipeGesture(String direction){

        ((JavascriptExecutor)driver).executeScript("mobile:swipe", ImmutableMap.of("direction", direction));

    }

    public void swipeTillElement(WebElement element, String direction){

        ((JavascriptExecutor)driver).executeScript("mobile:swipe", ImmutableMap.of( "element" ,((RemoteWebElement)element).getId(), "direction", direction));

    }

}
