package PageObjects.iOS.UIKitCatalogApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends iOSGestures {

    public IOSDriver driver;

    public HomePage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }


    /*
        Locators
     */

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement AlertViewsButton;

    @iOSXCUITFindBy(accessibility = "Steppers")
    private WebElement SteppersButton;

    @iOSXCUITFindBy(accessibility = "Web View")
    private WebElement WebViewButton;

    @iOSXCUITFindBy(accessibility = "Picker View")
    private WebElement PickerViewButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")
    private WebElement backButton;

    /*
        Actions
     */

    public void clickAlertViewsButton(){
        AlertViewsButton.click();
    }


    public void clickSteppersButton(){
        SteppersButton.click();
    }

    public void clickWebViewButton(){
        WebViewButton.click();
    }

    public void clickPickerViewButton(){
        PickerViewButton.click();
    }

    public void scrollTillWebViewSection(){

        scrollTillElement(WebViewButton);

    }

    public void clickBackButton(){

        backButton.click();

    }

}
