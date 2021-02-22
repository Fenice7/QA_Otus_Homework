package selenoidTests;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {

    protected WebDriver driver;
    private Logger logger = LogManager.getLogger(TestClass.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver = WebDriverFactory.createDriver(Browsers.CHROME);
//        driver.manage().window().maximize();
        String selenoidURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setVersion("88.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("screenResolution", "1920x1080");
        caps.setCapability("enableVideo", false);
        caps.setCapability("enableLog", true);

        driver = new RemoteWebDriver(new URL(selenoidURL), caps);

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
