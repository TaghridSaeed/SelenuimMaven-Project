package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserActions;
import utilities.Logs;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String URL = "http://automationexercise.com";

    /// /////////Locators/////////
    private By TextINHomePage = By.xpath("//h1/span");

    /// //////////Actions///////////
    @Step("Navigate to {URL}")
    public HomePage navigate() {
//        driver.get(URL);
        BrowserActions.navigate(driver, URL);
        return this;
    }

    /// //////////////// Validations \\\\\\\\\\\\\\\
    @Step("Assert On HomePage")
    public HomePage assertHomePage() {
        Logs.assertHomePage_Logs(driver);
        Assert.assertEquals(driver.findElement(TextINHomePage).getText(), "Automation");
        return this;
    }


}
