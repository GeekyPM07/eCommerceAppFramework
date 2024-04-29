package Utils;

/*
    All common code in Android, iOS class is present here.
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

public class AppiumUtils {


    /*
        AppiumDriver is parent of AndroidDriver, iOSDriver.
     */

    public AppiumDriverLocalService service;


    public double getFormattedAmount(String amount){

        return Double.valueOf(amount);

    }

    public void visibilityOfElementLocated(WebElement element, AppiumDriver driver){

        WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wdWait.until(ExpectedConditions.visibilityOf(element));

    }


    public List<HashMap<String,String>> getJSONData(String jsonFilePath) throws IOException {

        //Read the JSON File and then Converting JSON File to String -- using apache commons io dependency. System.getProperty("user.dir") + "src/main/java/TestData"
        String jsonString = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        //Converting JSON String to List of Hashmaps ( outer list start:[ hashmap-1: {k1:v1, k2: v2} hashmap-2: {k1:v1, k2:v2} ] list ends ) -- using Jackson Data bind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> listOfHashMaps = mapper.readValue(jsonString, new TypeReference<List<HashMap<String,String>>>() {
        });

        return listOfHashMaps;

    }

    public AppiumDriverLocalService startService(String JSFilePath, String IPAddress, int PORT){

        service = new AppiumServiceBuilder().withAppiumJS(new File(JSFilePath)).withIPAddress(IPAddress).usingPort(PORT).build();

        service.start();

        return service;

    }

    public String GetScreenshot(String testCase, AppiumDriver driver) throws IOException {

        /*
            1. Capture the SS and place in folder
         */


        //Virtual screenshot, not saved in system yet.
        File source = driver.getScreenshotAs(OutputType.FILE);
        //Destination where screenshot will be saved
        String destination = System.getProperty("user.dir")+"/ExtentReports/screenshots/" + testCase + ".png";
        //Copying the file
        FileUtils.copyFile(source, new File(destination));

        InputStream inputStream = new FileInputStream(destination);
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        String base64 = Base64.getEncoder().encodeToString(byteArray);


        return base64;

        /*
            2. Return the destination so that extent report can attach it to .html file
         */

    }


}
