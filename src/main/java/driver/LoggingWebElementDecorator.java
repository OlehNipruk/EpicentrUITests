package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

public class LoggingWebElementDecorator implements WebElement {
    private static final Logger logger = LogManager.getLogger(LoggingWebElementDecorator.class);
    private final WebElement wrappedElement;

    public LoggingWebElementDecorator(WebElement element) {
        this.wrappedElement = element;
    }

    @Override
    public void click() {
        logger.info("Clicking on element: " + wrappedElement);
        wrappedElement.click();
    }

    @Override
    public void submit() {
        logger.info("Submitting element: " + wrappedElement);
        wrappedElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        logger.info("Sending keys to element: " + wrappedElement + " Keys: " + String.join(", ", keysToSend));
        wrappedElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        logger.info("Clearing text in element: " + wrappedElement);
        wrappedElement.clear();
    }

    @Override
    public String getTagName() {
        return wrappedElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return wrappedElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return wrappedElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    @Override
    public String getText() {
        String text = wrappedElement.getText();
        logger.info("Getting text from element: " + wrappedElement + " Text: " + text);
        return text;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return wrappedElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return wrappedElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return wrappedElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
