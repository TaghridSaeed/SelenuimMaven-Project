package automation_exercise;

import jdk.jfr.Description;
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
        driver = DriverFactory.initiateDriver();
        //        driver = DriverFactory.initiateDriver(System.getProperty("browserName"), true,true);
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
                .SignupNewUser(testData.getTestData("UserName"), testData.getTestData("Email"));
        new EnterAccountInformation(driver).assertSignupPage()
                .selectSubscriptionOptions("offersCheckbox")
                .enterAccountInformation("tagsa221", "22", "January", "2002", "Female")
                .EnterAddressInformation("Taghreed", "Saeed", "Giza Systems", "ahmed shawky,banafseg 10 ", "United States", "USA", "cairo", "19989", "01020345966");
        new AccountCreated(driver).AssertAccountCreated()
                .ClickOnContinueButton();
        new MainMenu(driver).ClickDeleteAccButton();
        new AccountDeleted(driver).AssertAccountDeleted();


    }


    @AfterMethod
    public void tearDown() {

        driver.quit();

    }
}
