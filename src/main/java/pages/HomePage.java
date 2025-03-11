package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By searchInput = By.className("_JcImSJ");
    private By searchButton = By.xpath("//button[@aria-label='Пошук']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String productName) {
        sendKeys(searchInput, productName);
        clickElement(searchButton);
    }
}
