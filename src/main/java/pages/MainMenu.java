package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import utilities.ElementActions;


public class MainMenu {
    private WebDriver driver;

    /// /locators/////
    private By Loginbutton = By.xpath("//a[@href='/login']");
    private By DeleteAccButton = By.xpath("//a[@href='/delete_account']");

    /// / Actions/////
    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click On SignupButton")
    public void clickOnSignupButton() {
//        driver.findElement(Loginbutton).click();
        ElementActions.click(driver, Loginbutton);
    }

    @Step("Click On DeleteAccount Button")
    public MainMenu ClickDeleteAccButton() {
//        driver.findElement(DeleteAccButton).click();
        ElementActions.click(driver, DeleteAccButton);
        return this;
    }


}
