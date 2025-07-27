package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportSetup {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            initReports();
        }
        return extent;
    }

    public static void initReports() {
        if (extent == null) {
            // Timestamped report name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Automation Test Results");
            sparkReporter.config().setDocumentTitle("Extent Report for Selenium Tests");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Optional system info
            extent.setSystemInfo("Tester", "Kedarnath Lute");
            extent.setSystemInfo("Environment", "UAT");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
