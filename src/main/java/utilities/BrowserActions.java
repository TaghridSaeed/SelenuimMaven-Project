package utilities;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private static WebDriver driver;

    public static void navigate(WebDriver driver, String url) {
//        System.out.println("Navigating to url:" + url);
        Logs.BrowserActions_Logs(driver,url);
        driver.navigate().to(url);

    }
}
