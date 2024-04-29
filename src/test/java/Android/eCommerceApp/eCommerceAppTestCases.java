package Android.eCommerceApp;

import PageObjects.Android.eCommerceApp.ProductCataloguePage;
import PageObjects.Android.eCommerceApp.ProductCheckoutPage;
import PageObjects.Android.eCommerceApp.UserDetailsPage;
import TestUtils.Android.AndroidBaseTestClass;
import TestUtils.ExtentReportSetup;
import Utils.AppiumUtils;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class eCommerceAppTestCases extends AndroidBaseTestClass {

    String AirJordan9CheckoutPagePrice;

    String AirJordan1MidSECheckoutPagePrice;

    String totalPriceOnCheckoutPage;

    UserDetailsPage userDetailsPage;

    ProductCataloguePage productCatalogPage;

    ProductCheckoutPage productCheckoutPage;



    @BeforeClass(alwaysRun = true)
    public void setup(){

        userDetailsPage = new UserDetailsPage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void resetAppToHomePage() throws InterruptedException {

        userDetailsPage.setActivity();

    }


    /*
        TC1 - Fill FORM Details -> Go to Next Page
     */



    //Catching 2D Array object from @DataProvider getData method, and pull the data.
    @Test(dataProvider="getData")
    public void fillForm(HashMap<String,String> hMap) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        userDetailsPage.setCountrySelection(hMap.get("country"));

        userDetailsPage.enterName(hMap.get("name"));

//        userDetailsPage.setCountrySelection("Australia");

//        userDetailsPage.enterName("singh");

        if((userDetailsPage.femaleRadioButton).isDisplayed()){

            userDetailsPage.selectGender(hMap.get("gender"));

//            userDetailsPage.selectGender("Male");

            driver.hideKeyboard();

        } else {

            driver.hideKeyboard();
//            userDetailsPage.selectGender("Male");
            userDetailsPage.selectGender(hMap.get("gender"));

        }

        productCatalogPage = userDetailsPage.clickShopButton();

        Thread.sleep(3000);

    }

    /*
        TC2 - Don't Fill FORM Details -> Tap on Proceed -> Validate toast error message
     */

    @Test
    public void validateToastErrorMessage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        productCatalogPage = userDetailsPage.clickShopButton();

        String toastText = (userDetailsPage.invalidLoginToastMessage).getAttribute("name");

        Assert.assertEquals(toastText, "Please your name");

        Thread.sleep(3000);

    }

    /*
        TC3 - Fill FORM Details -> Add 2 Products to Cart -> Click on Cart Button
     */


    @Test
    public void addingProductToCart() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        userDetailsPage.setCountrySelection("Australia");

        userDetailsPage.enterName("Amy Jones");

        if((userDetailsPage.femaleRadioButton).isDisplayed()){

            userDetailsPage.selectGender("female");
            driver.hideKeyboard();

        } else {

            driver.hideKeyboard();
            userDetailsPage.selectGender("male");

        }

        userDetailsPage.clickShopButton();

        Thread.sleep(3000);

        //Selecting the product to add in cart

        productCatalogPage.addItem2CartViaXPathSibling("Air Jordan 9 Retro");
        productCatalogPage.addItem2CartViaXPathSibling("Air Jordan 1 Mid SE");

        productCatalogPage.ClickShopCartButton();

        Thread.sleep(3000);

        //Check the updated title is shown, when checkout page is loaded
        Assert.assertEquals(productCheckoutPage.getPageTitle(), "Cart");

        //Checking name of product in checkout page

        String checkoutPageProductName1 = productCheckoutPage.getProduct1Name();
        Assert.assertEquals(checkoutPageProductName1, "Air Jordan 9 Retro");

        String checkoutPageProductName2 = productCheckoutPage.getProduct2Name();
        Assert.assertEquals(checkoutPageProductName2, "Air Jordan 1 Mid SE");

        //Checking the Rate of the product in checkout page

        AirJordan9CheckoutPagePrice = productCheckoutPage.getProduct1Price();

        AirJordan1MidSECheckoutPagePrice = productCheckoutPage.getProduct2Price();

        Assert.assertEquals(productCatalogPage.getProduct1Price(), AirJordan9CheckoutPagePrice);

        Assert.assertEquals(productCatalogPage.getProduct2Price(), AirJordan1MidSECheckoutPagePrice);

    }


    @Test
    public void alternateAddingProductToCartWay() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        userDetailsPage.setCountrySelection("Australia");

        userDetailsPage.enterName("Amy Jones");

        if((userDetailsPage.femaleRadioButton).isDisplayed()){

            userDetailsPage.selectGender("female");
            driver.hideKeyboard();

        } else {

            driver.hideKeyboard();
            userDetailsPage.selectGender("male");

        }

        productCatalogPage = userDetailsPage.clickShopButton();

        Thread.sleep(3000);

        //Selecting the product to add in cart

        productCatalogPage.addItem2CartViaIndex();

        productCheckoutPage = productCatalogPage.ClickShopCartButton();

        Thread.sleep(3000);

        //Check the updated title is shown, when checkout page is loaded
        Assert.assertEquals(productCheckoutPage.getPageTitle(), "Cart");

        //Check product 1 Name in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct1Name(), "Air Jordan 4 Retro");

        //Check product 1 Price in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct1Price(),"$160.97");

        //Check product 2 Name in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct2Name(), "Air Jordan 1 Mid SE");

        //Check product 2 Price in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct2Price(),"$120.0");

    }


    @Test
    public void CheckingCartTotal() throws InterruptedException {

        double PPrice1 = 0;
        double PPrice2 = 0;
        double expectedTotalPrice = 0;
        double actualTotalPrice = 0;


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        userDetailsPage.setCountrySelection("Australia");

        userDetailsPage.enterName("Amy Jones");

        if((userDetailsPage.femaleRadioButton).isDisplayed()){

            userDetailsPage.selectGender("female");
            driver.hideKeyboard();

        } else {

            driver.hideKeyboard();
            userDetailsPage.selectGender("male");

        }

        productCatalogPage = userDetailsPage.clickShopButton();

        Thread.sleep(3000);

        //Selecting the product to add in cart

        productCatalogPage.addItem2CartViaIndex();

        productCheckoutPage = productCatalogPage.ClickShopCartButton();

        Thread.sleep(3000);

        //Check the updated title is shown, when checkout page is loaded
        Assert.assertEquals(productCheckoutPage.getPageTitle(), "Cart");

        //Check product 1 Name in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct1Name(), "Air Jordan 4 Retro");

        //Check product 1 Price in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct1Price(),"$160.97");

        //Check product 2 Name in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct2Name(), "Air Jordan 1 Mid SE");

        //Check product 2 Price in checkout page
        Assert.assertEquals(productCheckoutPage.getProduct2Price(),"$120.0");

        //Adding individual prices of product
        expectedTotalPrice = productCheckoutPage.getFormattedAmount(productCheckoutPage.getProduct1Price().split("\\$")[1]) + productCheckoutPage.getFormattedAmount(productCheckoutPage.getProduct2Price().split("\\$")[1]);

        //Actual price in Checkout Page
        actualTotalPrice = productCheckoutPage.getFormattedAmount(productCheckoutPage.getTotalPrice());

        //Comparing prices
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);

       productCheckoutPage.clickProceedButton();

        Thread.sleep(3000);

    }

    @Test
    public void longPressGestureProceedToPay() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        userDetailsPage.setCountrySelection("Australia");

        userDetailsPage.enterName("Amy Jones");

        if((userDetailsPage.femaleRadioButton).isDisplayed()){

            userDetailsPage.selectGender("female");
            driver.hideKeyboard();

        } else {

            driver.hideKeyboard();
            userDetailsPage.selectGender("male");

        }

        productCatalogPage = userDetailsPage.clickShopButton();

        Thread.sleep(3000);

        //Selecting the product to add in cart

        productCatalogPage.addItem2CartViaIndex();

        productCheckoutPage = productCatalogPage.ClickShopCartButton();

        Thread.sleep(3000);

        //Check the updated title is shown, when checkout page is loaded
        Assert.assertEquals(productCheckoutPage.getPageTitle(), "Cart");

        productCheckoutPage.clickCheckBox();

        productCheckoutPage.LongPressTandCLocator();

        Assert.assertEquals(productCheckoutPage.GetTandCAlertTitleText(), "Terms Of Conditions");

        productCheckoutPage.clickAlertPopUpCloseButton();

        productCheckoutPage.clickProceedButton();

        Thread.sleep(6000);

    }


    @Test(groups ={"Smoke"})
    public void automatingHybridApp() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        userDetailsPage.setCountrySelection("Australia");

        userDetailsPage.enterName("Amy Jones");

        if((userDetailsPage.femaleRadioButton).isDisplayed()){

            userDetailsPage.selectGender("female");
            driver.hideKeyboard();

        } else {

            driver.hideKeyboard();
            userDetailsPage.selectGender("male");

        }

        productCatalogPage = userDetailsPage.clickShopButton();

        Thread.sleep(3000);

        //Selecting the product to add in cart

        productCatalogPage.addItem2CartViaIndex();

        productCheckoutPage = productCatalogPage.ClickShopCartButton();

        Thread.sleep(3000);

        //Check the updated title is shown, when checkout page is loaded
        Assert.assertEquals(productCheckoutPage.getPageTitle(), "Cart");

        productCheckoutPage.clickCheckBox();

        productCheckoutPage.LongPressTandCLocator();

        Assert.assertEquals(productCheckoutPage.GetTandCAlertTitleText(), "Terms Of Conditions");

        productCheckoutPage.clickAlertPopUpCloseButton();

        productCheckoutPage.clickProceedButton();

        Thread.sleep(6000);

        //Web Portion starts

        //At the time gets the available contexts i.e Native, WebView
        Set<String> contexts;

        contexts = driver.getContextHandles();

        for(String context: contexts){
            System.out.println(context);

        }

        //Telling driver -- that you are in WebView now
        driver.context("WEBVIEW_com.androidsample.generalstore");

        driver.findElement(By.name("q")).sendKeys("F1");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //Telling driver -- back to Native app view
        driver.context("NATIVE_APP");

        //Do app related tasks again

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        AppiumUtils utils  = new AppiumUtils();
        List<HashMap<String,String>> listOfHashMaps = utils.getJSONData(System.getProperty("user.dir") + "/src/main/java/TestData/eCommerceApp.json");

        //Getting the data from hashmap i.e JSON File
        Object[][] oArr = new Object[][]{
                {listOfHashMaps.get(0)},  // {"Amy Jones", "Australia", "female"}
                {listOfHashMaps.get(1)}   //  {"Pratt", "India", "male"}
        };


        /* Earlier approach - hardcoding

        Object[][] oArr = new Object[][]{
                {"Amy Jones", "Australia", "female"},
                {"Pratt", "India", "male"}
        };

        */

        return oArr;

    }

}
