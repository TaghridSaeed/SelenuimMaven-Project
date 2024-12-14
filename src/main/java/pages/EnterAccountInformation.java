package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EnterAccountInformation {
    private WebDriver driver;


    public EnterAccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    /// /////////Locators/////////
    private By EnterInfoText = By.xpath("//h2/b");
    private By passwordfield = By.id("password");
    private By FemaleGender = By.id("id_gender2");
    private By MaleGender = By.id("id_gender1");
    private By daysDropDownlist = By.name("days");
    private By monthsDropDownlist = By.name("months");
    private By yearsDropDownlist = By.name("years");
    private By CheckBox1 = By.id("newsletter");
    private By CheckBox2 = By.id("optin");
    private By first_nameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By company = By.id("company");
    private By address1Field = By.id("address1");
    private By countryField = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    /// /Actions/////
    public enum Gender {
        Male, Female
    }

    public EnterAccountInformation enterAccountInformation(String Password, String Day, String Month, String Year, String GENDER) {

        Gender gender = Gender.valueOf(GENDER);
        if (gender == Gender.Female)
            driver.findElement(FemaleGender).click();
        else
            driver.findElement(MaleGender).click();

        driver.findElement(passwordfield).sendKeys(Password);
        new Select(driver.findElement(daysDropDownlist)).selectByVisibleText(Day);
        new Select(driver.findElement(monthsDropDownlist)).selectByVisibleText(Month);
        new Select(driver.findElement(yearsDropDownlist)).selectByVisibleText(Year);
        return this;
    }

    public enum Checkbox {
        newsletterCheckbox, offersCheckbox
    }

    public EnterAccountInformation selectSubscriptionOptions(String checkboxoption) {
        Checkbox option = Checkbox.valueOf(checkboxoption);
        if (option == Checkbox.newsletterCheckbox) {
            driver.findElement(CheckBox1).click();

        } else if (option == Checkbox.offersCheckbox) {
            driver.findElement(CheckBox2).click();
        }
        return this;

    }

    public void EnterAddressInformation(String first_name, String last_Name, String CompanyName, String address1, String countryName, String stateName, String cityName, String zipcode, String mobileNumber) {

        driver.findElement(first_nameField).sendKeys("Taghreed");
        driver.findElement(lastNameField).sendKeys("Saeed");
        driver.findElement(company).sendKeys("Giza Systems");
        driver.findElement(address1Field).sendKeys("ahmed shawky,banafseg 10 ");
        new Select(driver.findElement(countryField)).selectByVisibleText("United States");
        driver.findElement(stateField).sendKeys("USA");
        driver.findElement(cityField).sendKeys("cairo");
        driver.findElement(zipcodeField).sendKeys("19989");
        driver.findElement(mobileNumberField).sendKeys("01020345966");
        driver.findElement(createAccountButton).click();
    }

    /// /validations/////

    @Step("Assert On Signup Page")
    public EnterAccountInformation assertSignupPage() {
        Assert.assertEquals(driver.findElement(EnterInfoText).getText(), "ENTER ACCOUNT INFORMATION");
        return this;

    }
}
