package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class Checkout {
    private WebDriver driver;

    private By PlaceOrderButton = By.xpath("//a[@href='/payment']");

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click On click On Proceed To Checkout")
    public Checkout clickOnPlaceOrderButton() {
        ElementActions.click(driver, PlaceOrderButton);
        return this;

    }
}
