package PageObjects.iOS.UIKitCatalogApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PickerViewPage extends iOSGestures {

    public IOSDriver driver;

    public PickerViewPage(IOSDriver driver){

        super(driver);
        this.driver = driver;
        this.leftPickerView = null;
        this.middlePickerView = null;
        this.rightPickerView = null;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }


    /*
        Locators
     */

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Red color component value\"")
    public final WebElement leftPickerView;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Green color component value\"")
    public final WebElement middlePickerView;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Blue color component value\"")
    public final WebElement rightPickerView;




}
