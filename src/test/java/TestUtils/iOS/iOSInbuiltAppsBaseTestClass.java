package TestUtils.iOS;

import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class iOSInbuiltAppsBaseTestClass extends AppiumUtils {

    public AppiumDriverLocalService service;
    public IOSDriver driver;

    public WebDriverWait expWait;

    @BeforeTest(alwaysRun = true)
    public void ConfigureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        prop.load(fis);

        //startService(prop.getProperty("Appium_JS_File"), prop.getProperty("IPAddress"), Integer.parseInt(prop.getProperty("port")));

        XCUITestOptions op = new XCUITestOptions();
        op.setDeviceName(prop.getProperty("IOSDeviceName"));
        op.setPlatformVersion(prop.getProperty("IOSVersion"));
        op.setUdid(prop.getProperty("IOSDeviceUDID"));
        op.setWdaLaunchTimeout(Duration.ofSeconds(2));
        op.setBundleId(prop.getProperty("IOSInbuiltApp_BundleID"));

        /*
            Capabilities to set for Real device automation

        op.setCapability("xcodeOrgId", "Found in Team ID > Apple developer account Membership details");
        op.setCapability("xcodeSigningId", "iPhone Developer");
        op.setUdid("0728885E-DCF0-4EDB-AC28-39B6E7FA4EDF");
        op.setBundleId("com.example.apple-samplecode.UICatalog -- get from developer");

        */


        //URL class is deprecated in > JAVA 20 version
        URL appiumServerURL = new URL("http://" + prop.getProperty("IPAddress") + ":" + prop.getProperty("port"));

        driver = new IOSDriver(appiumServerURL,op);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest(alwaysRun = true)
    public void stopAppium(){
        driver.quit();
        //service.stop();
    }


    public void openInbuiltApp(String bundleId){

        ((JavascriptExecutor) driver).executeScript("mobile:launchApp", ImmutableMap.of("bundleId", bundleId));

    }
}
