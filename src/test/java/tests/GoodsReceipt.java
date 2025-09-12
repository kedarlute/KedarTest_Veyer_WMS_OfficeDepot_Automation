
package tests;

/**
 * @author: Kedarnath Lute
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoodReceipt {
    WebDriver driver;

   

    @Test(priority = 1)
    public void goods() {
        driver.findElement(By.id("menu_inbound")).click();
        driver.findElement(By.id("ok")).click();
        
        Assert.assertTrue(confirmation.isDisplayed(), "Sucess");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

