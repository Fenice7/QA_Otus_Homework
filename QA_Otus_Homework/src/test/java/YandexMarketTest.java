import config.ServerConfig;
import manager.Browsers;
import manager.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.yandex.YandexMarketPage;

import java.util.List;

public class YandexMarketTest {

    private WebDriver driver;
    Actions actions;
    private YandexMarketPage ya;
    WebDriverFactory wd = new WebDriverFactory();
    private Logger logger = LogManager.getLogger(YandexMarketTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        driver = wd.createDriver(Browsers.CHROME);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        logger.info("Драйвер запущен");
        ya = new YandexMarketPage(driver);

    }

    @Test
    public void YaTest() {
        driver.get(cfg.yandexMarket());
        logger.info("Открыли главную страницу");
        ya.jumpToElectronSection();
        logger.info("Перешли на старницу Электроника");
        ya.jumpToSmartphoneSection();
        logger.info("Перешли на старницу Смартфоны");
        ya.sortPrice();
        logger.info("Отсортировали по возрастанию цены");
        ya.filterSamsungCompany("Samsung");
        logger.info("Фильтр по Samsung");
        String samsung = ya.getFirstArticleTitle();
        logger.info(samsung);
        ya.addToCompare("Смартфон Samsung");
        logger.info("Добавили Samsung к сравнению");
        String popapCompareSamsung = ya.getTextCompare();
        Assert.assertEquals("Товар " + samsung + " добавлен к сравнению", popapCompareSamsung);
        ya.filterSamsungCompany("Samsung");
        logger.info("Сняли фильтр с Samsung");
        ya.filterSamsungCompany("Xiaomi");
        logger.info("Фильтр по Samsung");
        String xiaomi = ya.getFirstArticleTitle();
        logger.info(xiaomi);
        ya.addToCompare("Смартфон Xiaomi");
        logger.info("Добавили Xiaomi к сравнению");
        String popapCompareXiaomi = ya.getTextCompare();
        Assert.assertEquals("Товар " + xiaomi + " добавлен к сравнению", popapCompareXiaomi);
        ya.goToComparePage();
        logger.info("Переход на страницу сравнения");
        List<WebElement> mobileList = ya.compareList();
        logger.info(mobileList.size());
        Assert.assertEquals(mobileList.size(), 2);
        logger.info("Проверили что в сравнение добавили 2 позиции");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
