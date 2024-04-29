package PageObjects.iOS.TestApp;

import Utils.iOSGestures;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestAppHomePage extends iOSGestures {

    IOSDriver driver;

    public TestAppHomePage(IOSDriver driver){

        super(driver);
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*
        Locators
     */


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSlider[@name=\"AppElem\"]")
    private WebElement Slider;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Test Gesture\" AND type == \"XCUIElementTypeButton\"")
    private WebElement toggleButton;


    /*
        Actions
     */


    public void moveSliderToRight() throws InterruptedException {

        Slider.sendKeys("0.11%");

        Thread.sleep(3000);

        Slider.sendKeys("0.81%");
    }

    public void clickToggleButton(){

        toggleButton.click();

    }


}
