package automation_exercise;

import jdk.jfr.Description;
import org.testng.Assert;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.PropertiesReader;


public class Tests {
    private WebDriver driver;
    private JsonFileManager testData;

    @BeforeSuite
    public void BeforeSuite() {

        PropertiesReader.loadProperties();
    }

    @BeforeMethod
    public void SetUp() {
//        driver = DriverFactory.initiateDriver();
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"),
                Boolean.parseBoolean(System.getProperty("maximizeWindow")), Boolean.parseBoolean(System.getProperty("headLessExecution")));
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/SignUpTestsJsonFile.json");
    }

    @Test(description = "SignUp")
    @Description("Registration TestCase")
    public void registration() {
        new HomePage(driver)
                .navigate()
                .assertHomePage();
        new MainMenu(driver).clickOnSignupButton();
        new SignupPage(driver)
//                .assertSignupPage()
                .SignupNewUser(testData.getTestData("SignUp.UserName"),
                        testData.getTestData("SignUp.Email")+System.currentTimeMillis()+"@gmail.com");
        new EnterAccountInformation(driver)
//                .assertSignupPage()
                .selectSubscriptionOptions("offersCheckbox")
                .enterAccountInformation("tagsa221", "22", "January", "2002", "Female")
                .EnterAddressInformation("Taghreed", "Saeed", "Giza Systems", "ahmed shawky,banafseg 10 ", "United States", "USA", "cairo", "19989", "01020345966");
        new AccountCreated(driver)
                .AssertAccountCreated()
                .ClickOnContinueButton();
        new MainMenu(driver)
                .ClickDeleteAccButton();
        new AccountDeleted(driver)
                .AssertAccountDeleted();


    }

    @Test(description = "Login")
    @Description("Login TestCase")
    public void login() {
        new HomePage(driver)
                .navigate()
                .assertHomePage();
        new MainMenu(driver)
                .clickOnSignupButton();
        new SignupPage(driver)
                .SignupNewUser(testData.getTestData("SignUp.UserName")
                        , testData.getTestData("Login.Email"));
        new EnterAccountInformation(driver)
//                .assertSignupPage()
                .selectSubscriptionOptions("offersCheckbox")
                .enterAccountInformation("tagsa221", "22", "January", "2002", "Female")
                .EnterAddressInformation("Taghreed", "Saeed", "Giza Systems", "ahmed shawky,banafseg 10 ", "United States", "USA", "cairo", "19989", "01020345966");
        new AccountCreated(driver).AssertAccountCreated()
                .ClickOnContinueButton();
        new MainMenu(driver).clickOnLogOutButton();
        new SignupPage(driver).Login(testData.getTestData("Login.Email")
                , testData.getTestData("Login.Password"));
        new MainMenu(driver)
                .AsserOnLoggedinAsUsername()
                .ClickDeleteAccButton();
        new AccountDeleted(driver)
                .AssertAccountDeleted();

    }

    @Test(description = "Products")
    @Description("Product TestCase")
    public void VerifyAllProductsANDProductDetailPage() {
        new HomePage(driver)
                .navigate()
                .assertHomePage();
        new MainMenu(driver)
                .clickOnProductsButton();
        new ProductsPage(driver)
                .AsserOnProductsPageURL()
                .clickOnViewProductButton();
        new ProductsDetailsPage(driver)
                .AsserOnProductsDetails();

    }

    @Test(description = "Search")
    @Description("Search On Product TestCase")
    public void SearchOnProduct() {
        new HomePage(driver)
                .navigate()
                .assertHomePage();
        new MainMenu(driver)
                .clickOnProductsButton();
        new ProductsPage(driver)
                .SearchOnproduct()
                .AssertSearchedProducts();
    }

    @Test(description = "ADD to Cart")
    @Description("Add Products in Cart")
    public void AddProductsinCart() {
        new HomePage(driver)
                .navigate()
                .assertHomePage();
        new MainMenu(driver)
                .clickOnProductsButton();
        new ProductsPage(driver)
                .clickOnAddToCartButton1()
                .clickOnContinueShoppingbutton1()
                .clickOnAddToCartButton2()
                .clickOnViewCartButton();
        new ShoppingCart(driver)
                .AsserOnProduct1inCart()
                .AsserOnProduct2inCart();

    }

    @Test(description = "PlaceOrder")
    @Description("Place Order TestCase")
    public void PlaceOrder() {
        new HomePage(driver)
                .navigate()
                .assertHomePage();
        new MainMenu(driver).clickOnSignupButton();
        new SignupPage(driver)
                .SignupNewUser(testData.getTestData("SignUp.UserName"), testData.getTestData("SignUp.Email"));
        new EnterAccountInformation(driver)
                .selectSubscriptionOptions("offersCheckbox")
                .enterAccountInformation("tagsa221", "22", "January", "2002", "Female")
                .EnterAddressInformation("Taghreed", "Saeed", "Giza Systems", "ahmed shawky,banafseg 10 ", "United States", "USA", "cairo", "19989", "01020345966");
        new AccountCreated(driver)
                .AssertAccountCreated()
                .ClickOnContinueButton();
        new MainMenu(driver)
                .AsserOnLoggedinAsUsername()
                .clickOnProductsButton();
        new ProductsPage(driver)
                .clickOnAddToCartButton1()
                .clickOnContinueShoppingbutton1()
                .clickOnAddToCartButton2()
                .clickOnViewCartButton();
        new ShoppingCart(driver)
                .AsserOnProduct1inCart()
                .AsserOnProduct2inCart()
                .clickOnProceedToCheckoutbutton();
        new Checkout(driver)
                .clickOnPlaceOrderButton();
        new Payment(driver)
                .enterPaymentInfo()
                .clickOnConfirmOrderButton();
        new OrderPlaced(driver)
                .AssertOrderPlaced();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


}
