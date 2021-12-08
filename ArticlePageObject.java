package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
            TITLE ="org.wikipedia:id/view_page_title_text",
    FOOTER_ElEMENT = "//*[@text = 'View page in browser']";

    public ArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
    public WebElement waitForTitleElement ()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot 11", 15);
    }
    public String getArticleTitle ()
    {
        WebElement title_element =waitForTitleElement();
        return title_element.getAttribute("text");
    }
    public void swipeToFooter ()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ElEMENT),
                 "Cannot find the end of article",
                20
        );

    }
}