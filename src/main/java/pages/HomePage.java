package pages;

import driver.LoggingWebElementDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By searchInput = By.className("_JcImSJ");
    private By searchButton = By.xpath("//button[@aria-label='Пошук']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String productName) {
        LoggingWebElementDecorator searchInputElement = new LoggingWebElementDecorator(driver.findElement(searchInput));
        LoggingWebElementDecorator searchButtonElement = new LoggingWebElementDecorator(driver.findElement(searchButton));
        searchInputElement.sendKeys(productName);
        searchButtonElement.click();
    }
}
