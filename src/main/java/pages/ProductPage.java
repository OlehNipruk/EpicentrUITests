package pages;

import driver.LoggingWebElementDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCartButton = By.xpath("//button[text()='Купити']");
    private By productName = By.xpath("//h1[@class='_aql9TB _7TBdaN _GuJjCI']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        LoggingWebElementDecorator addToCartBtn = new LoggingWebElementDecorator(driver.findElement(addToCartButton));
        addToCartBtn.click();
    }

    public String getProductName() {
        LoggingWebElementDecorator productElement = new LoggingWebElementDecorator(driver.findElement(productName));
        return productElement.getText();
    }
}
