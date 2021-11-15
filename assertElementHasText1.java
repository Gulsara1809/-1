import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class assertElementHasText1 {
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability ("platformName","Android");
        capabilities.setCapability ("deviceName","AndroidTestDevice");
        capabilities.setCapability ("platformVersion","8.0");
        capabilities.setCapability ("automationName","Appium");
        capabilities.setCapability ("appPackage","org.wikipedia");
        capabilities.setCapability ("appActivity",".main.MainActivity");
        capabilities.setCapability ("app","C:\\Users\\g_kuatkhan\\Desktop\\JavaAppiumAutomation2\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown ()
    {
        driver.quit();
    }
    @Test
    public void testFirst1 () {
        WebElement element_to_init_search = driver.findElementByXPath("//*[@text='Search Wikipedia']");
        element_to_init_search.click();
        WebElement element_to_enter_search_line = waitForElementPresentByXpath(
                "//*[@text='Search Wikipedia']",
                "Cannot find search input",
                5
        );
    }



    @Test
    public void testFirst () {
        WebElement element_to_init_search = driver.findElementByXPath("//*[@text='Search Wikipedia']");
        element_to_init_search.click();


    }



    private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        By by = By.xpath(xpath);
        return  wait.withMessage(error_message + "\n").until(ExpectedConditions.presenceOfElementLocated(by));
    }
}

