package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Set WebDriver instance
    public static void setDriver(WebDriver driverInstance) {


        driver.set(driverInstance);
    }

    // Get WebDriver instance - Singleton Design Pattern
    public static WebDriver getDriver() {
        if (driver.get() == null)
            return driver.get();

    }

    // Remove the instance (important to avoid memory leaks)
    public static void unload() {
        if (driver.get() != null)
            driver.remove();
        
    }
}
