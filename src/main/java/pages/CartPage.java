package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private By productNameInCart = By.xpath("//h1[@data-product-name='']");
    private By cartItemsLocator = By.cssSelector("div[data-cart-product-item]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameInCart() {
        return getText(productNameInCart);
    }

    public int getCartItemCount() {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        return cartItems.size();
    }
}
