package cucumber.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static Logger logger = LogManager.getLogger(Driver.class);
    private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger.info("Драйвер поднят");
        }
        return driver;

    }

    public static void closedDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
            logger.info("Драйвер закрыт");
        }
    }

}
