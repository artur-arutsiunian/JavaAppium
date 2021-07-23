package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    public static final String
    FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
    ARTICLE_BY_TITLE_TPL = "//*[@text='TITLE']",
    WAIT_SECOND_ELEMENT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']",
    CLICK_ON_SECOND_ELEMENT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']",
    ASSERT_SURE = "org.wikipedia:id/view_page_title_text",
    CLICK_IN_EX6 = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='IPhone']",
    IMMEDIATELY_ASSERT = "//*[@text='IPhone']";

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "Cannot find folder by name" + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "Cannot find saved article by title" + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Cannot find saved article"
        );
    }

    public void waitForSecondElement()
    {
        this.waitForElementPresent(
                By.xpath(WAIT_SECOND_ELEMENT),
                "Cannot find 'Search Google' input",
                5
        );
    }

    public void clickOnSecondElement()
    {
        this.waitForElementAndClick(
                By.xpath(CLICK_ON_SECOND_ELEMENT),
                "Cannot find already created folder",
                5
        );
    }

    public void sure_element_has_title()
    {
        this.assertElementHasTitle(
                By.id(ASSERT_SURE),
                "Java (programming language)",
                "We see unexpected result"
        );
    }

    public void click_in_assert_title()
    {
        this.waitForElementAndClick(
                By.xpath(CLICK_IN_EX6),
                "Cannot find 'IPhone' article in search",
                5
        );
    }

    public void immediately_assert_element()
    {
        this.assertElementPresent(
                By.xpath(IMMEDIATELY_ASSERT),
                "Cannot find the end of the article",
                1
        );
    }
}