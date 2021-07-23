package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class  SearchPageObject extends MainPageObject{

    private static final String
    SEARCH_INIT_ELEMENT = "org.wikipedia:id/search_container",
    SEARCH_INPUT = "org.wikipedia:id/search_src_text",
    SEARCH_RESULT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']",
    SEARCH_CLEAR = "org.wikipedia:id/search_src_text",
    SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_BY_SUBSTRING_TPL= "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'{SUBSTRING}')]",
    SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
    SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found]",
    SEARCH_MAIN_MENU_ICON = "css:form>label#mw-mf-main-menu-button",
    SEARCH_WATCHLIST = "css:ul#p-personal>li.menu__item--unStar mw-ui-icon mw-ui-icon-before mw-ui-icon-minerva-unStar button",
    SEARCH_SECOND_ARTICLE_AND_DELETE = "css:li.page-summary with-watchstar>li.mw-ui-icon mw-ui-icon-wikimedia-unStar-progressive mw-ui-icon-element   watch-this-article watched button",
    SEARCH_REMAINING_ARTICLE = "css:#bodyContent>p#cite_ref-16";



    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATE METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATE METHODS */

    public void moveToMainMenu()
    {
        this.waitForElementAndClick(By.cssSelector(SEARCH_MAIN_MENU_ICON),"Cannot find main menu icon", 5);
    }

    public void clickWatchlist()
    {
        this.waitForElementAndClick(By.cssSelector(SEARCH_WATCHLIST), "Cannot find watchlist", 5);
    }

    public void deleteOneArticle()
    {
        this.waitForElementAndClick(By.cssSelector(SEARCH_SECOND_ARTICLE_AND_DELETE), "cannot find article", 5);
    }

    public void sureThatArticleExist()
    {
        this.waitForElementAndClick(By.cssSelector(SEARCH_REMAINING_ARTICLE), "cannot find existing element", 5);
    }


    public void initSearchInput()
    {
        this.waitForElementAndClick(By.id(SEARCH_INIT_ELEMENT),"Cannot find and click search init element", 5);
        this.waitForElementPresent(By.id(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    }

    public void waitSearchResult()
    {
        this.waitForElementPresent(By.xpath(SEARCH_RESULT), "cannot find search result", 5);
    }

    public void waitForClear()
    {
        this.waitForElementAndClear(By.id(SEARCH_CLEAR), "cannot clear", 5);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "search cancel button is still present", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find click search cancel button",5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_id = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_id), "Cannot find and click search result with substring " + substring, 10);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_id = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_id), "Cannot find search result with substring " + substring);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request",
                15
        );
            return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT),"Cannot find empty result element,", 15);

    }

    public void assertThereIsResultsOfSearch()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT),"We supposed not find any results");
    }
}
