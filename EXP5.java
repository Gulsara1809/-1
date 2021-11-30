import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class EXP5 {
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
    public void saveSecondArticleToMyList ()
    {
        waitForElementAndClick(
                By.xpath( "//*[@text='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[@text='Search…']"),
                "Astana",
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']"),
                "Cannot find search input3",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find search input4",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find search input4",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find search input5",
                5
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find search input6",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "papka",
                "Cannot find search input7",
                5

        );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot find search input8",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot find search input9X",
                5

        );
                waitForElementAndClick(
                        By.xpath( "//*[@text='Search Wikipedia']"),
                        "Cannot find search input",
                        5
                );

        waitForElementAndSendKeys(
                By.xpath("//*[@text='Search…']"),
                "Astana",
                "Cannot find search input",
                5

        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/view_list_card_list"),

                "Cannot find search input 'Astana–Premier Tech'",
        5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find search 1/1",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find search 1/2",
                5
        );

        waitForElementAndClick(
                By.xpath( "//*[@text= 'papka']"),
                "Cannot find search 1/3",
                5

        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot find search input9XX",
                5

        );






        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find search input10",
                5
        );
        waitForElementAndClick(
                By.xpath( "//*[@text= 'papka']"),
                "Cannot find search input12",
                5
        );
        swipeElementToLeft (
                By.xpath( "//*[@text='Nur-Sultan']"),
                "Cannot find search input13"

        );
        waitForElementNotPresent(
                By.xpath( "//*[@text= 'Nur-Sultan']"),
                "Cannot find search input14",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_list_item_container"),

                "Cannot find search input 'Astana–Premier Tech02'",
                5
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









    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x =size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release().perform();
    }


    protected void swipeUpQuick ()
    {
        swipeUp( 200);
    }
    protected void swipeUpToFindElement1(By by, String error_message,int max_swipes)
    {
        int already_swiped =0;
        while (driver.findElements(by).size() == 0){
            if (already_swiped > max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping up.\n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }



    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(by,
                error_message,
                10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction( driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x, middle_y)
                .release()
                .perform();

    }
}

