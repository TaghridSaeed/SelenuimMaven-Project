package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsDetailsPage {
    private WebDriver driver;
// p, category, price, availability, condition, brand

    private By Productname = By.xpath("//h2[text()='Blue Top']");
    private By Productcategory = By.xpath("//p[text()='Category: Women > Tops']");
    private By Productprice = By.xpath("//span[text()='Rs. 500']");
    private By Productavailability = By.xpath("//b[text()='Availability:']");
    private By Productcondition = By.xpath("//b[text()='Condition:']");
    private By Productbrand = By.xpath("//b[text()='Brand:']");

    public ProductsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Assert On Products Details")
    public void AsserOnProductsDetails() {
        Assert.assertEquals((driver.findElement(Productname).getText()),
                "Blue Top","Products Details is visible(product name, category, price, availability, condition, brand)");

    }
}

