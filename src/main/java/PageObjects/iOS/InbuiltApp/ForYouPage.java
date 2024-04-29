package PageObjects.iOS.InbuiltApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForYouPage extends iOSGestures {

    IOSDriver driver;

    public ForYouPage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*
        Locators
     */


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"For You\"")
    private WebElement ForYouButton;


    /*
        Actions
     */

    public void clickForYouButton(){

        ForYouButton.click();

    }

}
