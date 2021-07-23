package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyListsTests extends CoreTestCase
{
    private lib.ui.MainPageObject MainPageObject;

//    protected void setUp() throws Exception
//    {
//        super.setUp();
//
//        MainPageObject = new MainPageObject(driver);
//    }

    @Test
    @DisplayName("test about saving article")
    @Description("something to describe")
    @Step("Starting test testSaveFirstArticleToMyList")
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput1();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");


        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "My folder";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Macbook");
        SearchPageObject.clickByArticleWithSubstring("Intel-based line of Macintosh notebook computers");


        ArticlePageObject.waitForTitleElement();
        String article_title1 = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList1(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.ClickMyList();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
//        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_container']";
        MyListPageObject.waitForSecondElement();
        MyListPageObject.clickOnSecondElement();
        int amount_of_search_results = MainPageObject.getAmountOfElements(
                By.id("org.wikipedia:id/view_page_title_text")
        );
//
//        assertTrue(
//                "We found too few results",
//                amount_of_search_results > 0
//        );
//        MyListPageObject.sure_element_has_title();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//        );
//
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Macbook",
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Intel-based line of Macintosh notebook computers']"),
//                "Cannot find 'Search Macbook' input",
//                5
//        );
//
//       MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot find 'Search Google' input",
//                5
//        );

//        waitForElementPresent(
//                By.id("//android.widget.FrameLayout"),
//                "Cannot find article title",
//                15
//        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find options to add article to reading list",
//                5
//        );

//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/item_container"),
//                "Cannot find existing folder",
//                5
//        );


//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find X link",
//                5
//        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to My List",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find created folder",
//                30
//        );
//

//        MainPageObject.swipeElementToLeft(
//                By.xpath("//*[@text='MacBook Pro']"),
//                "Cannot find saved article"
//        );

//        MainPageObject.waitForElementPresent(
//                By.xpath(search_result_locator),
//                "Cannot find 'Search Google' input",
//                5
//        );

//        int amount_of_search_results = MainPageObject.getAmountOfElements(
//                By.xpath(search_result_locator)
//        );
//
//        Assert.assertTrue(
//                "We found too few results",
//                amount_of_search_results > 0
//        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath(search_result_locator),
//                "Cannot find already created folder",
//                5
//        );

//        MainPageObject.assertElementHasTitle(
//                By.id("//*[@resource-id='org.wikipedia:id/view_page_title_text']"),
//                "Google",
//                "We see unexpected result"
//        );
    }
}