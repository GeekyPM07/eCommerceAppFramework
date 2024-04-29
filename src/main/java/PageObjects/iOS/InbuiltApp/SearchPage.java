package PageObjects.iOS.InbuiltApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends iOSGestures {

    IOSDriver driver;

    public SearchPage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*
        Locators
     */


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Search\"")
    private WebElement SearchButton;


    /*
        Actions
     */

    public void ClickSearchButton(){

        SearchButton.click();

    }

}
