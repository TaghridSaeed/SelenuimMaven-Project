package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderPlaced {
    private WebDriver driver;


    public OrderPlaced(WebDriver driver) {
        this.driver = driver;
    }

    /// /locators////
    private By OrderPlacedMessage = By.xpath("//h2[@data-qa='order-placed']");

    /// /validations/////
    @Step("Assert On Account is Created")
    public OrderPlaced AssertOrderPlaced() {
        Assert.assertEquals(driver.findElement(OrderPlacedMessage).getText(), "ORDER PLACED!");
        return this;
    }
}
