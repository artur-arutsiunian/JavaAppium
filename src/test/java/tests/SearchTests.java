package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class SearchTests extends CoreTestCase
{
    @Test
//    @Features(value= {@Feature(value = "Search"), @Feature(value = "Article" )})
//    @DisplayName("test about cancel")
//    @Description("something to describe")
//    @Step("Starting test testCancelSearch")
//    @Severity(value = SeverityLevel.BLOCKER)
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitSearchResult();
        SearchPageObject.waitForClear();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    @Features(value= {@Feature(value = "Search"), @Feature(value = "Article" )})
    @DisplayName("test about assertTitle ")
    @Description("something to describe")
    @Step("Starting test testAssertTitle")
    @Severity(value = SeverityLevel.MINOR)
    public void testAssertTitle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Iphone");
        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.click_in_assert_title();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        MyListPageObject.immediately_assert_element();
    }

    @Test
    @Features(value= {@Feature(value = "Search"), @Feature(value = "Article" )})
    @DisplayName("test about amount")
    @Description("something to describe")
    @Step("Starting test testAmountOfNotEmptySearch")
    public void testAmountOfNotEmptySearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }
    @Test
    @Features(value= {@Feature(value = "Search"), @Feature(value = "Article" )})
    @DisplayName("test about empty amount")
    @Description("something to describe")
    @Step("Starting test testAmountOfEmptySearch")
    public void testAmountOfEmptySearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "cxczxx";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsResultsOfSearch();
    }
    }
