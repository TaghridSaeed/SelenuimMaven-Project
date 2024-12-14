package pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeleted {
    private WebDriver driver;

    public AccountDeleted(WebDriver driver) {
        this.driver = driver;
    }

    /// /locators////
    private By ActualDeleteMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");

    /// /validations/////
    @Step("Assert On Account is Deleted")
    public void AssertAccountDeleted() {
        Assert.assertEquals(driver.findElement(ActualDeleteMessage).getText(), "ACCOUNT DELETED!");
    }


}
