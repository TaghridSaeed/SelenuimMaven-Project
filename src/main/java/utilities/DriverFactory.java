package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize, boolean Headless) {

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions;
            if (Headless) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--Headless=new");
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
            System.out.println("Successfully initializing Chrome Browser on OS" +
                    System.getProperty("os.name") +
                    ",and it's version is:" + System.getProperty("os.version"));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = null;
            if (Headless) {
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--Headless");
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                driver = new FirefoxDriver();
            }
            System.out.println("Successfully initializing Firefox Browser ");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.out.println("Successfully initializing Edge Browser ");
        }
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("Window is maximized,And the new window size is:" + driver.manage().window().getSize());
        }
        return driver;

    }

    public static WebDriver initiateDriver(String browserType) {
        return initiateDriver(browserType, true, false);
    }

    public static WebDriver initiateDriver() {
        return initiateDriver(System.getProperty("browserName"),
                Boolean.parseBoolean(System.getProperty("maximizeWindow")),
                Boolean.parseBoolean(System.getProperty("headLessExecution")));
    }
}
