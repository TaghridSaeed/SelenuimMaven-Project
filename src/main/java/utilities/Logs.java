package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logs {
    private static WebDriver driver;

    public static void BrowserActions_Logs(WebDriver driver, String url) {
        System.out.println("Navigating to url:" + url);
    }

    public static void assertHomePage_Logs(WebDriver driver) {
        System.out.println("Assert On HomePage");
    }

    public static void Click_Logs(WebDriver driver, By elementLocator) {
        System.out.println("Clicking on element:" + driver.findElement(elementLocator).getAccessibleName());
    }


}
