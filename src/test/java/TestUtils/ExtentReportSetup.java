package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSetup {

    static ExtentReports extReport;

    public static ExtentReports configExtentReport(){

        String path = (System.getProperty("user.dir")+"/ExtentReports/reports/extent-report.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("ExtentReportsDemo Results");
        reporter.config().setDocumentTitle("Test Results");

        extReport = new ExtentReports();
        extReport.attachReporter(reporter);
        extReport.setSystemInfo("Tester","Pratt");

        return extReport;

    }


}
