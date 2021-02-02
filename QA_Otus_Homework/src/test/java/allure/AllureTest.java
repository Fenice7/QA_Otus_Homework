package allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import manager.Browsers;
import manager.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AllureTest {

    protected WebDriver driver;
    private Logger logger = LogManager.getLogger(AllureTest.class);
    Page page;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        page = new Page(driver);
        logger.info("Драйвер запущен");
    }

    @Test
    @Epic(value = "Google")
    @Feature(value = "Поиск")
    @Story(value = "Поиск по одному ключевому слову")
    @Description(value = "Тест проверяет поиск в google")
    public void allureTest() {
        page.openPage();
        page.searchByRequest("selenium");
        logger.info("Тест выполнен");

    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Драйвер закрыт");
    }

}
