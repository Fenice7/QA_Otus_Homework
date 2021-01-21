package cucumber.pages;

import config.ServerConfig;
import cucumber.driver.Driver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage {

    private Logger logger = LogManager.getLogger(MainPage.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private final WebDriver driver;

    public MainPage() {
        driver = Driver.getDriver();
    }

    public void openSite() {
        driver.get(cfg.otusUrl());
        logger.info("Открытие главной страницы сайта");
    }

    public void compareTitle() {
        String actualTitle = driver.getTitle();
        logger.info(actualTitle);
        assertThat(driver.getTitle(), containsString("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям"));
        logger.info("Проверка актуального title");
    }

    public void clickOnRegisterButton() {
        driver.findElement(By.cssSelector(".header2__auth")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.cssSelector(".new-log-reg__title"), "ВОЙДИТЕ В СВОЙ АККАУНТ"));
        logger.info("Открытие формы входа/регистрации");
    }

    public void enterEmail() {
        driver.findElement(By.cssSelector("div.new-input-line_slim:nth-child(3) > input:nth-child(1)")).sendKeys(cfg.email());
        logger.info("Ввод email");
    }

    public void enterPassword() {
        driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(cfg.psw());
        logger.info("Ввод пароля");
    }

    public void clickLogin() {
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).click();
        logger.info("Клик на кнопку Войти");

    }

    public void waitButtonMyCourses() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ic-blog-default-avatar")));
        logger.info("Успешная авторизация");
    }

    public void enterFailEmail() {
        driver.findElement(By.cssSelector("div.new-input-line_slim:nth-child(3) > input:nth-child(1)")).sendKeys("failmail@mail.com");
        logger.info("Ввод непверного email");
    }

    public void enterFailPass() {
        driver.findElement(By.cssSelector(".js-psw-input")).sendKeys("failpass");
        logger.info("Ввод неверного пароля");
    }

    public void checkLoginError() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.new-input-error.new-input-error_top.new-input-error_form.js-text")));
        String error = driver.findElement(By.cssSelector("div.new-input-error.new-input-error_top.new-input-error_form.js-text")).getText();
        logger.info(error);
        assertThat(error, containsString("Такая пара логин/пароль не существует"));
        logger.info("Проверка отображения ошибки - " + error);
    }

    public void goToKnowledgeSection() {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//p[text()='Преподавателям']"))).pause(1000).build().perform();
        driver.findElement(By.xpath("//a[@title='База знаний']")).click();
        logger.info("Переход в меню База Знаний");
    }

    public void openLK() {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".ic-blog-default-avatar"))).pause(1000).build().perform();
        driver.findElement(By.cssSelector(".header2-menu__dropdown-text")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches(cfg.otusLkAbout()));
    }

    public void goToNavItem(String section) {
        String xPath = "#categories_id a.nav__item[title='%s']";
        driver.findElement(By.cssSelector(String.format(xPath, section))).click();
        logger.info("Перешли в раздел - " + section);
    }

}
