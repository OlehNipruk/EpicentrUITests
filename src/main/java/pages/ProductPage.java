package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCartButton = By.xpath("//button[text()='Купити']");
    private By productName = By.xpath("//h1[@class='_aql9TB _7TBdaN _GuJjCI']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        clickElement(addToCartButton);
    }

    public String getProductName() {
        return getText(productName);
    }
}
