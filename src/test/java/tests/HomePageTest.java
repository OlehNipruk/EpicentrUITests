package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePageTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @Test
    public void testOpenHomePage() {
        logger.info("Test: testOpenHomePage - Opening home page");
        String expectedTitle = "Епіцентр";
        String actualTitle = driver.getTitle();
        logger.info("Home page title: {}", actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Home page title does not match expected value!");
    }

    @Test
    public void testSearchProduct() {
        homePage.searchForProduct("Ноутбук");
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL after search: {}", currentUrl);
        Assert.assertTrue(currentUrl.contains("noutbuki"), "URL does not contain expected search query!");
    }
}
