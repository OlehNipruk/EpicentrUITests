package driver;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingletonDriver {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SingletonDriver.class);

    private SingletonDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            DriverFactoryInterface factory = createDriverFactory();
            driver = factory.createDriver();
            driver.manage().window().maximize();
            logger.info("Browser window maximized");
        }
        return driver;
    }

    private static DriverFactoryInterface createDriverFactory() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        logger.info("Creating WebDriver for browser: " + browser);
        switch (browser) {
            case "chrome":
                return new ChromeDriverFactory();
            case "firefox":
                return new FirefoxDriverFactory();
            case "edge":
                return new EdgeDriverFactory();
            default:
                logger.error("Invalid browser specified: " + browser);
                throw new IllegalArgumentException("Unknown browser: " + browser);
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            logger.info("Closing WebDriver");
            driver.quit();
            driver = null;
        }
    }
}
