package iOS.UIKitCatalogApp;

import PageObjects.iOS.UIKitCatalogApp.AlertViewsPage;
import PageObjects.iOS.UIKitCatalogApp.HomePage;
import PageObjects.iOS.UIKitCatalogApp.PickerViewPage;
import PageObjects.iOS.UIKitCatalogApp.SteppersPage;
import TestUtils.iOS.iOSUIKitAppBaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UIKitCatalogAppTestCases extends iOSUIKitAppBaseTestClass {

    HomePage hPage;
    PickerViewPage pickerViewPage;

    SteppersPage steppersPage;

    AlertViewsPage alertViewsPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){

        hPage = new HomePage(driver);
        pickerViewPage = new PickerViewPage(driver);
        steppersPage = new SteppersPage(driver);
        alertViewsPage = new AlertViewsPage(driver);

    }


    @Test(groups ={"Smoke"})
    public void test1() {

        hPage.clickAlertViewsButton();
        alertViewsPage.EnterTextInDialogBox("hiiii");

        (alertViewsPage.ConfirmCancelBottomsheetInvokeButton).click();
        Assert.assertEquals((alertViewsPage.BottomSheetTextMessage).getText(), "A message should be a short, complete sentence.");
        (alertViewsPage.ConfirmButtonBottomsheet).click();

    }


    @Test
    public void iOSLongPress() {

        hPage.clickSteppersButton();
        steppersPage.LongPress();

    }


    @Test
    public void scrollDown() throws InterruptedException {


        hPage.scrollTillWebViewSection();

        hPage.clickWebViewButton();

        hPage.clickBackButton();

        Thread.sleep(5000);

        /*
             IMP - Scrolling in Picker View is different (use send keys to scroll)
         */


        hPage.clickPickerViewButton();

        (pickerViewPage.leftPickerView).sendKeys("30");

        String Picker1 =  (pickerViewPage.leftPickerView).getAttribute("value");

        Assert.assertEquals(Picker1, "30");

        (pickerViewPage.middlePickerView).sendKeys("240");

        String Picker2 = (pickerViewPage.middlePickerView).getAttribute("value");

        Assert.assertEquals(Picker2, "240");

        (pickerViewPage.rightPickerView).sendKeys("160");

        String Picker3 =  (pickerViewPage.rightPickerView).getAttribute("value");

        Assert.assertEquals(Picker3, "160");

    }

}
