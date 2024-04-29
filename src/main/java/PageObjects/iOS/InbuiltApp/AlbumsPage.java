package PageObjects.iOS.InbuiltApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlbumsPage extends iOSGestures {

    IOSDriver driver;

    public AlbumsPage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*
        Locators
     */


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Albums\"")
    private WebElement AlbumsButton;


    /*
        Actions
     */

    public void clickAlbumsButton(){

        AlbumsButton.click();

    }

    public void clickAllPhotosButton(){

        AllPhotosPage aPP = new AllPhotosPage(driver);
        aPP.clickAllPhotosButton();

    }

}
