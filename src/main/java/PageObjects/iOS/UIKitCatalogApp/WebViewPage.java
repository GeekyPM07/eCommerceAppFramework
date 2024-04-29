package PageObjects.iOS.UIKitCatalogApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WebViewPage extends iOSGestures {

    public IOSDriver driver;

    public WebViewPage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }



}
