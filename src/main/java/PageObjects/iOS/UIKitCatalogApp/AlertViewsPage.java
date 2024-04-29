package PageObjects.iOS.UIKitCatalogApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends iOSGestures {

    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver){

        super(driver);
        this.driver = driver;
        this.ConfirmCancelBottomsheetInvokeButton = null;
        this.BottomSheetTextMessage = null;
        this.ConfirmButtonBottomsheet = null;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
    private WebElement TextEntryDialogBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement TextEntryWritingBox;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement TextEntryDialogBoxOKButton;

    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'Confirm'")
    public final WebElement ConfirmCancelBottomsheetInvokeButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'A message'")
    public final WebElement BottomSheetTextMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Confirm'")
    public final WebElement ConfirmButtonBottomsheet;


    public void EnterTextInDialogBox(String text){

        TextEntryDialogBox.click();
        TextEntryWritingBox.sendKeys(text);
        TextEntryDialogBoxOKButton.click();

    }


}
