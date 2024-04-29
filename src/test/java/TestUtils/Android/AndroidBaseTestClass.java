package TestUtils.Android;

import TestUtils.Listeners;
import Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AndroidBaseTestClass extends AppiumUtils {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    public WebDriverWait expWait;

    /*
        When using Groups in testng.xml, below code will be ignored as groups is not provided. If we provide group = smoke, it will be ignored for groups = regression.

        Hence for generic code, use alwaysRun = true
     */

    @BeforeTest(alwaysRun = true)
    public void ConfigureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        prop.load(fis);

        //startService(prop.getProperty("Appium_JS_File"), prop.getProperty("IPAddress"), Integer.parseInt(prop.getProperty("port")));

        UiAutomator2Options op = new UiAutomator2Options();
        op.setDeviceName(prop.getProperty("AndroidDeviceName"));
        op.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        op.setApp(System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");

        //URL class is deprecated in > JAVA 20 version
        URL appiumServerURL = new URL("http://" + prop.getProperty("IPAddress") + ":" + prop.getProperty("port"));

        driver = new AndroidDriver(appiumServerURL,op);

    }

    @AfterTest(alwaysRun = true)
    public void stopAppium(){
        driver.quit();
        //service.stop();
    }
}
