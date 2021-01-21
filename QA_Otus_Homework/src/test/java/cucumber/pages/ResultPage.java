package cucumber.pages;

import cucumber.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
    private Logger logger = LogManager.getLogger(ResultPage.class);

    private final WebDriver driver;

    public ResultPage() {
        driver = Driver.getDriver();
    }

    public void iChooseTabBlogs() {
        driver.findElement(By.cssSelector("div.react-search__tabs > div:nth-child(2)")).click();
        logger.info("Выбор табы Блоги");
    }

    public void selectBlogInResultPage() {
        driver.findElement(By.xpath("//div[text()='QA и тестирование']")).click();
        logger.info("Выбор элемента в результатах поиска");
    }

}
