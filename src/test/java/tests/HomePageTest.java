package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    @Test
    public void testSearchProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("Ноутбук");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("noutbuki"), "URL does not contain expected search query!");
    }
}
