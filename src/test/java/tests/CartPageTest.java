package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartPageTest extends BaseTest {
    private static final String NOTEBOOK_PRODUCT_NAME = "Ноутбук Lenovo ideapad Slim 5 16ABR8 16\" (82XG009HRA) cloud grey";
    private static final String MOUSE_PRODUCT_NAME = "Мишка Logitech Wireless Mouse M185 black/red (910-002240)";

    @Test
    public void testAddToCart() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.searchForProduct(NOTEBOOK_PRODUCT_NAME);
        productPage.addProductToCart();
        String productNameInCart = cartPage.getProductNameInCart();
        Assert.assertEquals(productNameInCart, NOTEBOOK_PRODUCT_NAME, "Product not found in cart");
    }

    @Test
    public void testAddMultipleProductsToCart() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.searchForProduct(NOTEBOOK_PRODUCT_NAME);
        productPage.addProductToCart();
        driver.navigate().back();
        homePage.searchForProduct(MOUSE_PRODUCT_NAME);
        productPage.addProductToCart();
        int cartItemCount = cartPage.getCartItemCount();
        Assert.assertEquals(cartItemCount, 2, "Cart does not contain expected number of items!");
    }
}
