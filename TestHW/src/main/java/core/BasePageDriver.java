package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageDriver {
    protected static WebDriver driver;

    public static void setDriver(WebDriver driver_p){
        driver = driver_p;
    }

    public static void checkUrl(int waitTime, String url){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        driverWait.until(ExpectedConditions.urlContains(url));
    }

    public static void waitUntilElementVisible (int waitTime, WebElement el){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        driverWait.until(ExpectedConditions.visibilityOf(el));
    }


}
