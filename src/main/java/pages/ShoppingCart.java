package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class ShoppingCart {
    private WebDriver driver;

    private By FirstIteminCart = By.xpath("//a[@href='/product_details/1']");
    private By SecondIteminCart = By.xpath("//a[@href='/product_details/2']");
    private By ProceedToCheckout = By.xpath("//a[@class='btn btn-default check_out']");

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click On click On Proceed To Checkout")
    public ShoppingCart clickOnProceedToCheckoutbutton() {
        ElementActions.click(driver, ProceedToCheckout);
        return this;

    }

    @Step("Assert On First items in cart")
    public ShoppingCart AsserOnProduct1inCart() {
        Assert.assertEquals((driver.findElement(FirstIteminCart).getText()),
                "Blue Top");
        return this;

    }

    @Step("Assert On Second in cart")
    public ShoppingCart AsserOnProduct2inCart() {
        Assert.assertEquals((driver.findElement(SecondIteminCart).getText()),
                "Men Tshirt");
        return this;

    }
}
