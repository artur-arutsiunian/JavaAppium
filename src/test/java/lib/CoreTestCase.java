package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;

public class CoreTestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        System.out.println("setUp test driver");
//        System.out.println("setUp test driver");
//        driver = Platform.getInstance().getDriver();
//
//        System.out.println(driver);

//        this.rotateScreenPortrait();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/arturarutsiunian/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        this.createAllurePropertyFile();
//        this.rotateScreenPortrait();
    }

    @After
    @Step("Remove driver and session")
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Step("Rotate screen to portrait mode")
    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @Step("Rotate screen to landscape mode")
    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @Step("Send mobile app to background (this method does nothing for Mobile Web")
    protected void backgroundApp(int seconds) {
    }

    private void createAllurePropertyFile() {
        System.out.println("createAllurePropertyFile");
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            System.out.println(driver);
            props.setProperty("Environment", driver.getPlatformName());
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }
}
//    {
////        driver.runAppInBackground(seconds);
////        driver.runAppInBackground(Duration.ofSeconds(seconds));
//    }

//    private void skipWelcomePageForIOSApp()
//    {
//        if(P)
//    }
