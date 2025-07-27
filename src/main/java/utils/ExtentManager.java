package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static void removeExtentTest() {
        extentTest.remove();
    }

    // Create and set test in ThreadLocal
    public static ExtentTest startTest(String testName, String description) {
        ExtentReports extent = ExtentReportSetup.getExtent();
        ExtentTest test = extent.createTest(testName, description);
        setExtentTest(test);
        return test;
    }

    public static ExtentTest getTest() {
        return getExtentTest();
    }

}

