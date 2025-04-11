package tests;

import driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected String baseUrl;
    private int implicitWait;
    private int explicitWait;

    protected HomePage homePage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        implicitWait = ConfigReader.getIntProperty("implicitWait");
        driver = SingletonDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        baseUrl = ConfigReader.getProperty("baseUrl");
        driver.get(baseUrl);
        logger.info("Navigating to {}", baseUrl);
        logger.info("Implicit Wait: {}s", implicitWait);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        SingletonDriver.closeDriver();
    }
}
