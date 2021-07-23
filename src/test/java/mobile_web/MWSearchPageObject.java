//package mobile_web;
//
//import io.appium.java_client.AppiumDriver;
//import lib.ui.SearchPageObject;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class MWSearchPageObject extends SearchPageObject {
//
//    static {
//        SEARCH_INIT_ELEMENT = "css:button#searchIcon",
//                SEARCH_INPUT = "css:form>input[type='search']",
//                SEARCH_RESULT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']",
//                SEARCH_CLEAR = "org.wikipedia:id/search_src_text",
//                SEARCH_CANCEL_BUTTON = "css:button.cancel",
//                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikipedia-description')][contains(text(), '{SUBSTRING}')]",
//                SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary",
//                SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results",
//                SEARCH_MAIN_MENU_ICON = "css:form>label#mw-mf-main-menu-button",
//                SEARCH_WATCHLIST = "css:ul#p-personal>li.menu__item--unStar mw-ui-icon mw-ui-icon-before mw-ui-icon-minerva-unStar button",
//                SEARCH_SECOND_ARTICLE_AND_DELETE = "css:li.page-summary with-watchstar>li.mw-ui-icon mw-ui-icon-wikimedia-unStar-progressive mw-ui-icon-element   watch-this-article watched button",
//                SEARCH_REMAINING_ARTICLE = "css:#bodyContent>p#cite_ref-16";
//
//    }
//        public void clickByArticleWithSubstring(String substring)
//        {
//            String search_result_id = getResultSearchElement(substring);
//            this.waitForElementAndClick(By.xpath(search_result_id), "Cannot find and click search result with substring " + substring, 10);
//        }
//
//    public MWSearchPageObject(RemoreWebDriver driver)
//    {
//        super(driver);
//    }
//}
