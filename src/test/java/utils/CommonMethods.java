package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class CommonMethods extends PageInitializer{
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(String url){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.get(url);
        driver.manage().window().maximize();

        initializePageObjects();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    public void closeBrowser(){
        driver.quit();
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static void sendKeyReturn(WebElement element){
        element.sendKeys(Keys.RETURN);
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    //Method returns wait object
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    //take screenshot method for capturing all the screenshots
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile
                    (sourceFile, new File
                            (Constants.SCREENSHOT_FILEPATH +
                                    fileName+" "+
                                    getTimeStamp("yyyy-MM-dd-HH-mm-ss")
                                    +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        //after getting the date, I need to format it as per my requirement
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //it willl return the formatted date as per the pattern in string format
        return sdf.format(date);
    }
}
