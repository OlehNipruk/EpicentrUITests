package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).getDriver();
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                logger.error("Test failed: {}. Screenshot: {}", result.getName(), screenshotPath);
            }
        }
    }
}
