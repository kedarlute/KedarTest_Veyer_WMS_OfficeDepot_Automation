package listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ExtentManager;
import utils.ExtentReportSetup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static utils.DriverManager.getDriver;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[INFO] Test Suite Started: " + context.getName());
        ExtentReportSetup.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[INFO] Test Suite Finished: " + context.getName());
        ExtentReportSetup.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentManager.startTest(testName, "test");
        ExtentManager.getTest().log(Status.INFO, "Test Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Screenshot on failure
        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
        try {
            ExtentManager.getTest().fail("Screenshot on failure:",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            ExtentManager.getTest().fail("Screenshot attach failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not commonly used
    }

    private String captureScreenshot(String testName) {
        try {
            String path = "screenshots/" + testName + ".png";
            File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            return path;
        } catch (Exception e) {
            return "Screenshot failed: " + e.getMessage();
        }
    }
}
