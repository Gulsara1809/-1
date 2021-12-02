import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class EXP6 {
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\g_kuatkhan\\Desktop\\JavaAppiumAutomation2\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @Test
public void testAmountOfNotEmptySearch ()
    {
        waitForElementAndClick(
                By.xpath( "//*[@text='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        String search_line = "Aral Sea1";
        waitForElementAndSendKeys(
            By.xpath("//*[@text='Search…']"),
            search_line,
            "Cannot find search input17",
            5
    );

       String search_result_locator = "//*[@resource-id ='org.wikipedia:id/search_results_list']/*[@resource-id = 'org.wikipedia:id/page_list_item_container']";
        waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find search input18" + search_line,
                5
        );
        int amount_of_search_results = getAmountOfElements(
                By.xpath(search_result_locator)
        );

        waitForElementAndClick(
                By.xpath ( "//*[@resource-id = 'org.wikipedia:id/page_list_item_container']"),
                "Cannot find search input20",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Aral Sea']"),
                "Cannot find search input19",
                15
        );
        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }





    private WebElement waitForElementPresent (By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );

    }
    private WebElement waitForElementPresent1 (By by, String error_message,long timeoutInSeconds) {
        WebElement element = this.waitForElementPresent (by,error_message,timeoutInSeconds);
        element.clear();
        return element;
    }
    private WebElement waitForElementAndClick (By by, String error_message,long timeoutInSeconds){
        WebElement element = this.waitForElementPresent(by,error_message,timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = this.waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    private boolean waitForElementNotPresent (By by, String error_message,long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.withMessage(error_message + "\n").until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds){
        WebElement element = this.waitForElementAndClear(by,error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }






    private int getAmountOfElements(By by)
    {
        List elements =driver.findElements(by);
        return elements.size ();
    }
}

