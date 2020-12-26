import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.Browsers;
import manager.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    protected WebDriver driver;
    private Logger logger = LogManager.getLogger(TestClass.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver = WebDriverFactory.createDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        logger.info("Драйвер запущен");
    }

    @Test
    public void openPage() {
        driver.get(cfg.otusUrl());
        logger.info("Открыта страница отус");
        driver.getTitle().equals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям");
        logger.info("Проверка title страницы");

    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
