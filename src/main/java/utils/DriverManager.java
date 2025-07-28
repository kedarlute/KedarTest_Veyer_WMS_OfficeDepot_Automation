package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.UIManager.put;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Set WebDriver instance for Selenoid Setup
    public static void setDriver(WebDriver driverInstance) throws MalformedURLException {
        if (driver.get() == null)
        {
        ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
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
