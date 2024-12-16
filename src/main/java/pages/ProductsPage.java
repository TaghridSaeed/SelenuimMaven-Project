package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class ProductsPage {
    private WebDriver driver;

    private By ViewProductButton = By.xpath("//a[@href='/product_details/1']");
    private By SearchBar = By.id("search_product");
    private By SearchButton = By.id("submit_search");
    private By SearchedProductsText = By.xpath("//h2[text()='Searched Products']");
    private By AddtoCartbuttonItem1 = By.xpath("//a[@data-product-id='1']");
    private By AddtoCartbuttonItem2 = By.xpath("//a[@data-product-id='2']");
    private By ContinueShoppingbuttonItem1 = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    private By ViewCartButton = By.xpath("//u");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Click On ViewProduct Button")
    public void clickOnViewProductButton() {
        ElementActions.click(driver, ViewProductButton);
    }

    @Step("Search on product")
    public ProductsPage SearchOnproduct() {
        driver.findElement(SearchBar).sendKeys("Blue Top");
        ElementActions.click(driver, SearchButton);
//        driver.findElement(SearchButton).click();

        return this;
    }

    @Step("Click On Add To Cart Button for 1 item")
    public ProductsPage clickOnAddToCartButton1() {
        ElementActions.click(driver, AddtoCartbuttonItem1);
        return this;
    }

    @Step("Click On Add To Cart Button 2 item")
    public ProductsPage clickOnAddToCartButton2() {
        ElementActions.click(driver, AddtoCartbuttonItem2);
        return this;
    }

    @Step("Click On click On Continue Shopping button1")
    public ProductsPage clickOnContinueShoppingbutton1() {
        ElementActions.click(driver, ContinueShoppingbuttonItem1);
        return this;

    }

    @Step("Click On View Cart Button")
    public ProductsPage clickOnViewCartButton() {
        ElementActions.click(driver, ViewCartButton);
        return this;

    }

    @Step("Assert On Searched Products")
    public void AssertSearchedProducts() {
        Assert.assertEquals((driver.findElement(SearchedProductsText).getText()),
                "SEARCHED PRODUCTS", "Searched Products is visible");
    }

    @Step("Assert On LogOut Button")
    public ProductsPage AsserOnProductsPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products", "user is navigated to ALL PRODUCTS page successfully ");
        return this;
    }


}
