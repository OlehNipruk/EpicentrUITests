package listeners;

import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
        if (screenshotPath != null) {
            logger.error("Test failed: {}. Screenshot: {}", result.getName(), screenshotPath);
        }
    }
}
