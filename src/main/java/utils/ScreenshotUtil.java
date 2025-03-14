package utils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

//    public static void takeScreenshot(WebDriver driver, String testName) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//        String timestamp = dateFormat.format(new Date());
//        String fileName = "screenshots/" + testName + "_" + timestamp + ".png";
//
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destination = new File(fileName);
//
//        try {
//            FileHandler.copy(screenshot, destination);
//            logger.info("Screenshot saved: " + destination.getAbsolutePath());
//        } catch (IOException e) {
//            logger.error("Failed to save screenshot: " + e.getMessage());
//        }
//    }

    public static String takeScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(srcFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }



}
