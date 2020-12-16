package pages.otus;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Otus {

    private WebDriver driver;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public Otus(WebDriver driver) {
        this.driver = driver;
    }

    private By login = By.cssSelector(".header2__auth-reg");
    private By inputEmail = By.cssSelector("div.new-input-line_slim:nth-child(3) > input:nth-child(1)");
    private By inputPass = By.cssSelector(".js-psw-input");
    private By buttonLogin = By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)");
    private By loginTitle = By.cssSelector(".new-log-reg__title");
    private By userMenu = By.cssSelector(".ic-blog-default-avatar");

    //element for about()
    private By name = By.id("id_fname");
    private By lastName = By.id("id_lname");
    private By blogName = By.id("id_blog_name");
    private By bDay = By.cssSelector("input[name='date_of_birth']");
    private By countryInput = By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)");
    private By checkRussia = By.cssSelector("button[title='Россия']");
    private By cityInput = By.cssSelector(".js-lk-cv-dependent-slave-city > label:nth-child(1) > div:nth-child(2)");
    private By checkMoskow = By.cssSelector("button[title='Москва']");
    private By enLevelInput = By.cssSelector("div.container__col_12:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > label:nth-child(1) > div:nth-child(2)");
    private By checkEnLevel = By.cssSelector("button[title='Начальный уровень (Beginner)']");

    //Contacts
    private By checkContacts = By.cssSelector("div.js-formset-row:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)");
    private By wayOfCommunication = By.xpath("//span[text()='Способ связи']");
    private By vkXpath = By.xpath("//div[@data-num='0']//button[@title='VK']");
    private By whatsAppXpath = By.xpath("//div[@data-num='1']//button[@title='WhatsApp']");
    private By vkInput = By.xpath("//input[@name='contact-0-value']");
    private By whatsAppInput = By.xpath("//input[@name='contact-1-value']");
    private By addContact = By.xpath("//button[text()='Добавить']");

    private By saveAndContinue = By.cssSelector("button[title='Сохранить и продолжить']");

    private By success = By.cssSelector("span.success");

    //Переменные с вносимыми данными
    public String userName = "Anna";
    public String userLastName = "Kizeeva";
    public String dateBDay = "25.08.1992";
    public String country = "Россия";
    public String city = "Москва";
    public String langLevel = "Начальный уровень (Beginner)";
    public String vkData = "https://vk.com/test_url";
    public String whatsAppData = "+79150000000";



    public void auth() {

        driver.findElement(login).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(loginTitle, "ВОЙДИТЕ В СВОЙ АККАУНТ"));
        driver.findElement(inputEmail).sendKeys(cfg.email());
        driver.findElement(inputPass).sendKeys(cfg.psw());
        driver.findElement(buttonLogin).submit();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(userMenu));

    }

    public void enterLK() {

        new Actions(driver).moveToElement(driver.findElement(userMenu)).pause(1000).build().perform();
        driver.findElement(By.cssSelector(".header2-menu__dropdown-text")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches(cfg.otusLkAbout()));

    }


    public void about() {

        driver.findElement(name).clear();
        driver.findElement(lastName).clear();
        driver.findElement(blogName).clear();
        driver.findElement(bDay).clear();

        driver.findElement(name).sendKeys(userName);
        driver.findElement(lastName).sendKeys(userLastName);
        driver.findElement(blogName).sendKeys(userName);

        driver.findElement(bDay).sendKeys(dateBDay);

        //Страна
        if (!driver.findElement(countryInput).getText().contains(country)) {
            driver.findElement(countryInput).click();
            driver.findElement(checkRussia).click();
        }
        //Город
        if (!driver.findElement(cityInput).getText().contains(city)) {
            driver.findElement(cityInput).click();
            driver.findElement(checkMoskow).click();
        }

        //Уровень англ
        if (!driver.findElement(enLevelInput).getText().contains(langLevel)) {
            driver.findElement(enLevelInput).click();
            driver.findElement(checkEnLevel).click();
        }

        //Контакты
        if(!driver.findElement(checkContacts).getText().contains("VK")) {
            driver.findElement(wayOfCommunication).click();
            driver.findElement(vkXpath).click();
            driver.findElement(vkInput).sendKeys(vkData);
            driver.findElement(addContact).click();
            driver.findElement(wayOfCommunication).click();
            driver.findElement(whatsAppXpath).click();
            driver.findElement(whatsAppInput).sendKeys(whatsAppData);
        }

        driver.findElement(saveAndContinue).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(success, "Данные успешно сохранены"));
    }


    public String getNameValue() {
        return driver.findElement(name).getAttribute("value");
    }

    public String getLastNameValue() {
        return driver.findElement(lastName).getAttribute("value");
    }

    public String getBDayValue() {
        return driver.findElement(bDay).getAttribute("value");
    }

    public String getCountryText() {
        return driver.findElement(countryInput).getText();
    }

    public String getCityText() {
        return driver.findElement(cityInput).getText();
    }

    public String getLangLevel() {
        return driver.findElement(enLevelInput).getText();
    }

    public String getVkData() {
        return driver.findElement(vkInput).getAttribute("value");
    }

    public String getWhatsAppData() {
        return driver.findElement(whatsAppInput).getAttribute("value");
    }


}
