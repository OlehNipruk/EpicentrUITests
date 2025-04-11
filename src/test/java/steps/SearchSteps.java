package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import pages.HomePage;
import utils.LogUtil;
import driver.SingletonDriver;

import static org.testng.AssertJUnit.assertTrue;

public class SearchSteps {
    private WebDriver driver;
    private HomePage homePage;
    private static final Logger logger = LogUtil.getLogger(SearchSteps.class);

    public SearchSteps() {
        driver = SingletonDriver.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        logger.info("Opening homepage");
        driver.get("https://epicentrk.ua/");
    }

    @When("User searches for {string}")
    public void user_searches_for(String productName) {
        logger.info("Searching for product: {}", productName);
        homePage.searchForProduct(productName);
    }

    @Then("The search URL should contain {string}")
    public void the_search_url_should_contain(String expectedText) {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL after search: {}", currentUrl);
        assertTrue("URL does not contain expected search query!", currentUrl.contains(expectedText));
    }
}
