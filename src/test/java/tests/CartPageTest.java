package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CartPageTest extends BaseTest {
    private static final String NOTEBOOK_PRODUCT_NAME = "Ноутбук Lenovo ideapad Slim 5 16ABR8 16\" (82XG009HRA) cloud grey";
    private static final String MOUSE_PRODUCT_NAME = "Мишка Logitech Wireless Mouse M185 black/red (910-002240)";
    private static final Logger logger = LogManager.getLogger(CartPageTest.class);

    @Test
    public void testAddToCart() {
        logger.info("Test: testAddToCart");
        homePage.searchForProduct(NOTEBOOK_PRODUCT_NAME);
        productPage.addProductToCart();
        String productNameInCart = cartPage.getProductNameInCart();
        Assert.assertEquals(productNameInCart, NOTEBOOK_PRODUCT_NAME, "Product not found in cart");
    }

    @Test
    public void testAddMultipleProductsToCart() {
        logger.info("Test: testAddMultipleProductsToCart - Searching for product '{}'", NOTEBOOK_PRODUCT_NAME);
        homePage.searchForProduct(NOTEBOOK_PRODUCT_NAME);
        logger.info("Adding '{}' to the cart", NOTEBOOK_PRODUCT_NAME);
        productPage.addProductToCart();
        driver.navigate().back();
        logger.info("Navigating back to the home page");
        logger.info("Searching for product '{}'", MOUSE_PRODUCT_NAME);
        homePage.searchForProduct(MOUSE_PRODUCT_NAME);
        logger.info("Adding '{}' to the cart", MOUSE_PRODUCT_NAME);
        productPage.addProductToCart();
        int cartItemCount = cartPage.getCartItemCount();
        logger.info("Cart item count: {}", cartItemCount);
        Assert.assertEquals(cartItemCount, 2, "Cart does not contain expected number of items!");
    }
}
