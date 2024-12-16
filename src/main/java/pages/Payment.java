package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class Payment {
    private WebDriver driver;

    private By NameonCardField = By.xpath("//input[@name='name_on_card']");
    private By CardNumberField = By.xpath("//input[@name='card_number']");
    private By CVCField = By.xpath("//input[@name='cvc']");
    private By ExpirationMonthField = By.xpath("//input[@name='expiry_month']");
    private By ExpirationYearField = By.xpath("//input[@name='expiry_year']");
    private By ConfirmOrderButton = By.xpath("//button[@id='submit']");

    public Payment(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Payment Info")
    public Payment enterPaymentInfo() {
        driver.findElement(NameonCardField).sendKeys("Card");
        driver.findElement(CardNumberField).sendKeys("01236789");
        driver.findElement(CVCField).sendKeys("311");
        driver.findElement(ExpirationMonthField).sendKeys("6");
        driver.findElement(ExpirationYearField).sendKeys("2028");
        return this;

    }
    @Step("Click On click On Confirm Order Button")
    public Payment clickOnConfirmOrderButton() {
        ElementActions.click(driver, ConfirmOrderButton);
        return this;

    }
}
