package iOS.InbuiltApp;

import PageObjects.iOS.InbuiltApp.AlbumsPage;
import PageObjects.iOS.InbuiltApp.AllPhotosPage;
import TestUtils.iOS.iOSInbuiltAppsBaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InbuiltAppTestCases extends iOSInbuiltAppsBaseTestClass {

    AlbumsPage albumsPage;
    AllPhotosPage allPhotosPage;

    @BeforeClass(alwaysRun = true)
    public void Setup(){

        albumsPage = new AlbumsPage(driver);
        allPhotosPage = new AllPhotosPage(driver);
    }


    @Test
    public void OpenInbuiltApp(){

        openInbuiltApp("com.apple.mobileslideshow");

    }


    @Test(groups ={"Smoke"})
    public void SwipingGesture() throws InterruptedException {

        openInbuiltApp("com.apple.mobileslideshow");

        albumsPage.clickAllPhotosButton();

        List<WebElement> allPhotos = driver.findElements(By.xpath("//XCUIElementTypeCell"));
        System.out.println("All photos present in photos app: " +allPhotos.size());

        allPhotos.get(0).click();

        /*
            Swipe
         */

        ArrayList<String> al = new ArrayList<>();


        //We want to swipe till all the pictures finish.

        for(int i=0; i < allPhotos.size(); i++){

            //Get the current photo timestamp

            al.add(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));

            int size = 0;

            size = al.size();

            //From 2nd photo onwards

            if(size > 1){

                //Compare 2nd and 1st photo timestamps, if unique
                if(!al.get(size-1).equals(al.get(size-2))){

                    //If Unique then Swipe
                    allPhotosPage.swipe("left");
                }

            }

            //When 1st photo -- swipe directly

            else if (size  == 1){
                //Swipe
                allPhotosPage.swipe("left");
            }

        }

        //Pressing back button
        allPhotosPage.clickBackButton();

        allPhotosPage.clickAlbumsButton();

        Thread.sleep(3000);
    }
}
