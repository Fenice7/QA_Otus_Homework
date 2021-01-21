package cucumber.steps;

import cucumber.pages.ItemPage;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemPageStepDef {
    private Logger logger = LogManager.getLogger(ItemPageStepDef.class);
    ItemPage itemPage = new ItemPage();

    @Then("Checking that the blog title matches {string}")
    public void checkingThatTheBlogTitleMatches(String blogName) {
        itemPage.assertTitleMatches(blogName);
        logger.info("Сравнение названия блога с введенным запросом");
    }
}
