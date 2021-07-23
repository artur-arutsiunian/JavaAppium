//package tests;
//
//import lib.CoreTestCase;
//import lib.ui.*;
//import org.junit.Test;
//import org.openqa.selenium.By;
//
//public class MyListsTests extends CoreTestCase
//{
//    private lib.ui.MainPageObject MainPageObject;
//
//    protected void setUp() throws Exception
//    {
//        super.setUp();
//
//        MainPageObject = new MainPageObject(driver);
//    }
//
//    @Test
//    public void testSaveFirstArticleToMyList() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
//
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//
//        ArticlePageObject.waitForTitleElement();
//        ArticlePageObject.addArticleToMyListForMW();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Macbook");
//        SearchPageObject.clickByArticleWithSubstring("ntel-based line of Macintosh notebook computers");
//        ArticlePageObject.waitForTitleElement();
//        ArticlePageObject.addArticleToMyListForMW();
//        SearchPageObject.moveToMainMenu();
//        SearchPageObject.clickWatchlist();
//        SearchPageObject.deleteOneArticle();
//        SearchPageObject.sureThatArticleExist();
//
////        SearchPageObject.initSearchInput();
////        SearchPageObject.typeSearchLine("Macbook");
////        SearchPageObject.clickByArticleWithSubstring("Intel-based line of Macintosh notebook computers");
////
////
////        ArticlePageObject.waitForTitleElement();
////        String article_title1 = ArticlePageObject.getArticleTitle();
////        ArticlePageObject.addArticleToMyList1(name_of_folder);
////        ArticlePageObject.closeArticle();
////
////        NavigationUI NavigationUI = new NavigationUI(driver);
////        NavigationUI.ClickMyList();
////
////        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
////        MyListPageObject.openFolderByName(name_of_folder);
////        MyListPageObject.swipeByArticleToDelete(article_title);
//////        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_container']";
////        MyListPageObject.waitForSecondElement();
////        MyListPageObject.clickOnSecondElement();
////        int amount_of_search_results = MainPageObject.getAmountOfElements(
////                By.id("org.wikipedia:id/view_page_title_text")
////        );
//    }
//}