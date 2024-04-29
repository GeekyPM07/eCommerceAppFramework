package PageObjects.iOS.InbuiltApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AllPhotosPage extends iOSGestures {

    IOSDriver driver;

    public AllPhotosPage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

     /*
        Locators
     */


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"All Photos\"")
    private WebElement AllPhotosButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"All Photos\"]")
    private WebElement BackButton;


    /*
        Actions
     */


    public void clickAllPhotosButton(){

        AllPhotosButton.click();

    }

    public void clickAlbumsButton(){

        AlbumsPage ap = new AlbumsPage(driver);
        ap.clickAlbumsButton();

    }

    public void clickBackButton(){

        BackButton.click();

    }

    public void swipe(String direction){

        swipeGesture(direction);

    }


}
