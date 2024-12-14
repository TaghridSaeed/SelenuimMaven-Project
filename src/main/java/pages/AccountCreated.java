package pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountCreated {
    private WebDriver driver;


    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }

    /// /locators////
    private By ActualCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By ContinueButton = By.xpath("//*[@data-qa=\"continue-button\"]");

    /// /Actions/////
    @Step("Click On Continue Button")
    public void ClickOnContinueButton() {
        driver.findElement(ContinueButton).click();

    }

    /// /validations/////
    @Step("Assert On Account is Created")
    public AccountCreated AssertAccountCreated() {
        Assert.assertEquals(driver.findElement(ActualCreatedMessage).getText(), "ACCOUNT CREATED!");
        return this;
    }


}
