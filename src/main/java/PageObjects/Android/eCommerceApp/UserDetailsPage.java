package PageObjects.Android.eCommerceApp;

import Utils.AndroidGestures;
import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage extends AndroidGestures {


    public AndroidDriver driver;


    public UserDetailsPage(AndroidDriver driver){

        super(driver);

        this.driver = driver;

        this.nameField = null;

        this.femaleRadioButton = null;

        this.maleRadioButton = null;

        this.countrySelectionDropdown = null;

        this.shopBtn = null;

        this.invalidLoginToastMessage = null;


        //init Elements -- used to construct all the locators using @FindBy Annotation
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }

    /*
        Locators
     */


    //@AndroidBy -- Find this locator in Android
    //Constructed locator after using initElements - driver.findElement(By.id(""))
    @AndroidBy(id = "com.androidsample.generalstore:id/nameField")
    public final WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public final WebElement femaleRadioButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public final WebElement maleRadioButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    public final WebElement countrySelectionDropdown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public final WebElement shopBtn;

    @AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
    public final WebElement invalidLoginToastMessage;


    /*
        Actions
     */

    public void enterName(String name){

        nameField.sendKeys(name);

    }

    public void selectGender(String gender){

        if (gender.contains("female")){
            femaleRadioButton.click();
        }
        else
        {
            maleRadioButton.click();
        }

    }

    public void setCountrySelection(String countryName){

        countrySelectionDropdown.click();
        scrollTillElement(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

    }

    public ProductCataloguePage clickShopButton(){

        shopBtn.click();

        //Create next page object

        ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);

        return productCataloguePage;
    }


    public void setActivity(){

        Activity aObj = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");

        ((JavascriptExecutor)driver).executeScript("mobile:startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));


    }


}
