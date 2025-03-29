package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverFactory {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser").toLowerCase();
            logger.info("Initializing WebDriver for browser: " + browser);
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    logger.error("Invalid browser specified: " + browser);
                    throw new IllegalArgumentException("Unknown browser: " + browser);
            }
            driver.manage().window().maximize();
            logger.info("Browser window maximized");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            logger.info("Closing WebDriver");
            driver.quit();
            driver = null;
        }
    }
}
