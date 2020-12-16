import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import pages.otus.Otus;


public class OtusPageObjectTest {

    protected static WebDriver driver;
    WebDriverFactory wd = new WebDriverFactory();
    private Otus otus;
    private Logger logger = LogManager.getLogger(OtusPageObjectTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = wd.createDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        otus = new Otus(driver);
        logger.info("Драйвер запущен");

    }

    @Test
    public void openOtus() {

        driver.get(cfg.otusUrl());
        logger.info("Открыть сайт Отуса");

        otus.auth();
        logger.info("Авторизоваться на сайте");

        otus.enterLK();
        logger.info("Войти в личный кабинет");

        otus.about();
        logger.info("В разделе О себе заполнить все поля Личные данные и добавить не менее двух контактов");

        driver.quit();
        logger.info("Драйвер закрыт");

        driver = wd.createDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        otus = new Otus(driver);
        logger.info("Поднят новый драйвер");

        driver.get(cfg.otusUrl());
        logger.info("Открыть сайт Отуса в чистом браузере");

        otus.auth();
        logger.info("Авторизоваться на сайте");

        otus.enterLK();
        logger.info("Войти в личный кабинет");

        String actualName = otus.getNameValue();
        Assert.assertEquals(otus.userName, actualName);
        logger.info("Проверка соответствия имени");

        String actualLastName = otus.getLastNameValue();
        Assert.assertEquals(otus.userLastName, actualLastName);
        logger.info("Проверка соответствия фамилии");

        Assert.assertEquals(otus.userName, actualName);
        logger.info("Проверка соответствия имени в блоге");

        String actualBDay = otus.getBDayValue();
        Assert.assertEquals(otus.dateBDay, actualBDay);
        logger.info("Проверка соответствия даты рождения");

        String actualCountry = otus.getCountryText();
        Assert.assertEquals(otus.country, actualCountry);
        logger.info("Проверка соответствия страны");

        String actualCity = otus.getCityText();
        Assert.assertEquals(otus.city, actualCity);
        logger.info("Проверка соответствия города");

        String actualLangLevel = otus.getLangLevel();
        Assert.assertEquals(otus.langLevel, actualLangLevel);
        logger.info("Проверка соответствия уровня англ языка");

        String actualVkData = otus.getVkData();
        Assert.assertEquals(otus.vkData, actualVkData);
        logger.info("Проверка соответствия данных Вк");

        String actualWhatsAppData = otus.getWhatsAppData();
        Assert.assertEquals(otus.whatsAppData, actualWhatsAppData);
        logger.info("Проверка соответствия данных WhatsApp");

    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Драйвер закрыт");
    }

}
