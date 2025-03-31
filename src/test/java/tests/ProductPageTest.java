package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductPageTest extends BaseTest {
    private static final String EXISTING_PRODUCT_NAME = "Ноутбук Lenovo ideapad Slim 5 16ABR8 16\" (82XG009HRA) cloud grey";
    private static final String NON_EXISTING_PRODUCT_NAME = "Неіснуючий продукт";

    @Test
    public void testProductName() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.searchForProduct(EXISTING_PRODUCT_NAME);
        String productName = productPage.getProductName();
        Assert.assertEquals(productName, EXISTING_PRODUCT_NAME, "Product name does not match");
    }

    @Test
    public void testProductNotFound() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.searchForProduct(NON_EXISTING_PRODUCT_NAME);
        String productName = productPage.getProductName();
        Assert.assertTrue(productName.isEmpty(), "Product should not be found on the page.");
    }
}
