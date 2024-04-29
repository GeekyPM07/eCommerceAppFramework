package iOS.TestApp;

import PageObjects.iOS.TestApp.TestAppHomePage;
import TestUtils.iOS.iOSTestAppBaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAppTestCases extends iOSTestAppBaseTestClass {

    TestAppHomePage testAppHomePage;

    @BeforeClass(alwaysRun = true)
    public void setup(){

        testAppHomePage = new TestAppHomePage(driver);

    }


    @Test(groups ={"Smoke"})
    public void iOSSliderTest() throws InterruptedException {

        testAppHomePage.moveSliderToRight();

    }


    @Test
    public void ToggleOnANDOff(){

        testAppHomePage.clickToggleButton();

        System.out.println("Toggle button clicked");

    }

}
