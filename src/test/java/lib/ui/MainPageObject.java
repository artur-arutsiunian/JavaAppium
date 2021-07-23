package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }



    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public WebElement assertElementHasTitle(By by, String expected_text, String error_message){
        WebElement titleElement = waitForElementPresent(by, error_message);
        String article_title = titleElement.getAttribute("text");
        Assert.assertEquals(
                error_message,
                expected_text,
                article_title
        );
        return titleElement;
    }

    public WebElement assertElementHasText(By by, String expected_text, String error_message){
        WebElement titleElement = waitForElementPresent(by, error_message);
        String article_title = titleElement.getAttribute("text");
        Assert.assertEquals(
                error_message,
                expected_text,
                article_title
        );
        return titleElement;
    }

//    public void SwipeUp(int timeOfSwipe)
//    {
//        TouchAction action = new TouchAction(driver);
//        Dimension size = driver.manage().window().getSize();
//        int x = size.width / 2;
//        int start_y = (int) (size.height * 0.8);
//        int end_y = (int) (size.height * 0.2);
//
//
//        action
//                .press(x, start_y)
//                .waitAction(timeOfSwipe)
//                .moveTo(x, end_y)
////                .press(PointOption.point(x, start_y))
////                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
////                .moveTo(PointOption.point(x, end_y))
//                .release()
//                .perform();
//    }

//    public void swipeUpQuick()
//    {
//        SwipeUp(200);
//    }

    public void  assertElementPresent(By by, String error_message, int max_element)
    {
        int already_present = 1;
        while (driver.findElements(by).size() == 1){

            if(already_present == max_element){
                waitForElementPresent(by, "Cannot find element. \n" + error_message, 0);
                return;
            }

//            swipeUpQuick();
//            ++already_present;
        }
    }

    public void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                30);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getWidth();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
//        action
//                .press(right_x,  middle_y)
//                .waitAction(300)
////                .press(PointOption.point(right_x, middle_y))
////                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//                .moveTo(left_x, middle_y)
//                .release()
//                .perform();
    }

    public int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + "" + error_message);
        }
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    public WebElement waitForElementVisible(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage("\n " + error_message + "\n");
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(by)
        );
    }
    public String takeScreenshot(String name)
    {
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name +"_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error: " +e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path)
    {
        byte[] bytes = new byte[0];

        try{
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }
}
