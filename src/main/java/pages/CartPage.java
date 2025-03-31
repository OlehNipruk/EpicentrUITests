package pages;

import driver.LoggingWebElementDecorator;
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
        LoggingWebElementDecorator productElement = new LoggingWebElementDecorator(driver.findElement(productNameInCart));
        String productName = productElement.getText();
        return productName;
    }

    public int getCartItemCount() {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        LoggingWebElementDecorator cartItemElement = new LoggingWebElementDecorator(cartItems.get(0));
        int itemCount = cartItems.size();
        System.out.println("Cart item count: " + itemCount);
        return itemCount;
    }
}
