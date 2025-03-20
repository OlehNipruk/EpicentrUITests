package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductPageTest extends BaseTest {
    @Test
    public void testProductName() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.searchForProduct("Ноутбук Lenovo ideapad Slim 5 16ABR8 16\" (82XG009HRA) cloud grey");
        String productName = productPage.getProductName();
        Assert.assertEquals(productName, "Ноутбук Lenovo ideapad Slim 5 16ABR8 16\" (82XG009HRA) cloud grey", "Product name does not match");
    }

    @Test
    public void testProductNotFound() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.searchForProduct("Неіснуючий продукт");
        String productName = productPage.getProductName();
        Assert.assertTrue(productName.isEmpty(), "Product should not be found on the page.");
    }
}
