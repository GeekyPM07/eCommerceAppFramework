package TestUtils.iOS;

import Utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class iOSTestAppBaseTestClass extends AppiumUtils {

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
        op.setApp(System.getProperty("user.dir") + "/src/test/resources/TestApp 3.app");
        op.setWdaLaunchTimeout(Duration.ofSeconds(2));

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

}
