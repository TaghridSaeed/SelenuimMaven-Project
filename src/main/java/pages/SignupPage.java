package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage {
    private WebDriver driver;
    private MainMenu mainmenu;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    /// //Locators//////
    private By TextINSignupPage = By.xpath("(//h2)[3]");
    private By signupname = By.xpath("//input[@data-qa='signup-name']");
    private By signupemail = By.xpath("//input[@data-qa='signup-email']");
    private By signupbutton = By.xpath("//button[@data-qa='signup-button']");

    /// //Actions/////
    public SignupPage SignupNewUser(String name, String email) {
        driver.findElement(signupname).sendKeys(name);
        driver.findElement(signupemail).sendKeys(email);
        driver.findElement(signupbutton).click();
        return this;
    }
    public SignupPage assertSignupPage()
    {
        Assert.assertEquals((driver.findElement(TextINSignupPage).getText()), "New User Signup!");
        return this;

    }
}
