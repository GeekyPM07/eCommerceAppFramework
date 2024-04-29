package TestUtils;

import Utils.AppiumUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.ah.A;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends AppiumUtils implements ITestListener {

    AppiumDriver driver;

    //Responsible for info regarding a particular test in a report.
    ExtentTest test;

    //Responsible for adding testcases into the report
    ExtentReports extentReportSetup = ExtentReportSetup.configExtentReport();


    public void onTestStart(ITestResult result) {

        test = extentReportSetup.createTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS,"Test PASSED!");

    }

    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL,"TEST FAILED!!!");
        test.fail(result.getThrowable());

        //Getting driver from BaseTestClass
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //Add screenshot from path to extent report.

        try {
            test.addScreenCaptureFromBase64String(GetScreenshot(result.getMethod().getMethodName(), driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {

        this.onTestFailure(result);

    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {

        extentReportSetup.flush();

    }


}
