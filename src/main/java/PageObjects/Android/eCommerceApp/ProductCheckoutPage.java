package PageObjects.Android.eCommerceApp;

import Utils.AndroidGestures;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductCheckoutPage extends AndroidGestures {

    AndroidDriver driver;

    public String title;

    public String product1Name;

    public String product1Price;

    public String product2Name;

    public String product2Price;

    public ProductCheckoutPage(AndroidDriver driver){

        super(driver);

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*

        Locators

    */


    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement titleLocator;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 4 Retro']")
    private WebElement AirJordan4Retro;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$160.97\"]")
    private WebElement AirJordan4RetroPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan 6 Rings']")
    private WebElement Jordan6Rings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$165.0\"]")
    private WebElement Jordan6RingsPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 1 Mid SE']")
    private WebElement AirJordan1MidSE;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$120.0\"]")
    private WebElement AirJordan1MidSEPrice;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPriceLocator;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement clickCheckBoxLocator;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement clickProceedButtonLocator;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement TandCLocator;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement TandCAlertTitle;


    @AndroidFindBy(id = "android:id/button1")
    private WebElement AlertPopUpCloseButton;


     /*
        Actions
     */

    public String getPageTitle(){

        title = titleLocator.getText();

        return title;

    }

    public String getProduct1Name(){

        product1Name = AirJordan4Retro.getText();

        return product1Name;

    }

    public String getProduct1Price(){

        product1Price = AirJordan4RetroPrice.getText();

        return product1Price;

    }

    public String getProduct2Name(){

        product2Name = AirJordan1MidSE.getText();

        return product2Name;

    }

    public String getProduct2Price(){

        product2Price = AirJordan1MidSEPrice.getText();

        return product2Price;

    }

    public String getTotalPrice(){

        return totalPriceLocator.getText().split(" ")[1];
    }

    public void clickCheckBox(){

        clickCheckBoxLocator.click();
    }

    public void clickProceedButton(){

        clickProceedButtonLocator.click();

    }

    public void LongPressTandCLocator(){

        longPressAction(TandCLocator);

    }

    public String GetTandCAlertTitleText(){

        return TandCAlertTitle.getText();

    }

    public void clickAlertPopUpCloseButton(){

        AlertPopUpCloseButton.click();

    }

}
