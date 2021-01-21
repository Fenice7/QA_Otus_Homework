package cucumber.pages;

import cucumber.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KnowledgeBasePage {

    private Logger logger = LogManager.getLogger(KnowledgeBasePage.class);

    private final WebDriver driver;

    public KnowledgeBasePage() {
        driver = Driver.getDriver();
    }

    public void searchBarInput(String blogName) {
        driver.findElement(By.cssSelector("div.vertical-middle")).click();
        driver.findElement(By.cssSelector("div.vertical-middle > form:nth-child(1) > div:nth-child(1) > input")).sendKeys(blogName);
        logger.info("Ввод в поиске - " + blogName);
    }

    public void clickFind() {
        driver.findElement(By.cssSelector("div.vertical-middle > form:nth-child(1) > div:nth-child(1) > button")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.react-search__tabs > div:nth-child(2)")));
        logger.info("Нажатие на кнопку найти");
    }


}
