package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ProductPageTest extends BaseTest {
    private static final String EXISTING_PRODUCT_NAME = "Ноутбук Lenovo ideapad Slim 5 16ABR8 16\" (82XG009HRA) cloud grey";
    private static final String NON_EXISTING_PRODUCT_NAME = "Неіснуючий продукт";
    private static final Logger logger = LogManager.getLogger(ProductPageTest.class);

    @Test
    public void testProductName() {
        logger.info("Test: testProductName - Searching for existing product '{}'", EXISTING_PRODUCT_NAME);
        homePage.searchForProduct(EXISTING_PRODUCT_NAME);
        String productName = productPage.getProductName();
        logger.info("Expected product name: '{}', Found product name: '{}'", EXISTING_PRODUCT_NAME, productName);
        Assert.assertEquals(productName, EXISTING_PRODUCT_NAME, "Product name does not match");
    }

    @Test
    public void testProductNotFound() {
        logger.info("Test: testProductNotFound - Searching for non-existing product '{}'", NON_EXISTING_PRODUCT_NAME);
        homePage.searchForProduct(NON_EXISTING_PRODUCT_NAME);
        String productName = productPage.getProductName();
        logger.info("Expected no product found, Actual product name: '{}'", productName);
        Assert.assertTrue(productName.isEmpty(), "Product should not be found on the page.");
    }
}
