package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By productNameInCart = By.xpath("//h1[@data-product-name='']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameInCart() {
        return getText(productNameInCart);
    }
}
