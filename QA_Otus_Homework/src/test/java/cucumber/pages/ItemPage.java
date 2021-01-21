package cucumber.pages;

import config.ServerConfig;
import cucumber.driver.Driver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemPage {
    private Logger logger = LogManager.getLogger(ItemPage.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    private final WebDriver driver;

    public ItemPage() {
        driver = Driver.getDriver();
    }

    public void assertTitleMatches(String blogName) {
        assertThat(driver.getTitle(), containsString(blogName));

    }


}
