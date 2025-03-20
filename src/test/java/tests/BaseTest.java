package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import driver.DriverFactory;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected String baseUrl;
    private int implicitWait;
    private int explicitWait;

    @BeforeMethod
    public void setUp() {
        implicitWait = ConfigReader.getIntProperty("implicitWait");
        explicitWait = ConfigReader.getIntProperty("explicitWait");
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        baseUrl = ConfigReader.getProperty("baseUrl");
        driver.get(baseUrl);
        logger.info("Test setup complete. Using baseUrl: {}", baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
