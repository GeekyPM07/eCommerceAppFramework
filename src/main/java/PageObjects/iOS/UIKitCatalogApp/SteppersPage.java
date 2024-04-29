package PageObjects.iOS.UIKitCatalogApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SteppersPage extends iOSGestures {

    public IOSDriver driver;

    public SteppersPage(IOSDriver driver){

        super(driver);
        this.driver = driver;
        this.elementToLongPress = null;


        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*
        Locators
     */

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][3]")
    public final WebElement elementToLongPress;

    /*
        Actions
     */

    public void LongPress(){

        longPressAction(elementToLongPress);

    }

}
