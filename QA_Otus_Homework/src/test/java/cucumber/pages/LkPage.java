package cucumber.pages;

import cucumber.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LkPage {
    private Logger logger = LogManager.getLogger(LkPage.class);
    private final WebDriver driver;

    public LkPage() {
        driver = Driver.getDriver();
    }

    public void openInviteSection() {
        driver.findElement(By.xpath("//a[@title='Приведи друга']")).click();
        logger.info("Открытие раздела Приведи друга");
    }

    public void enterEmailInInput(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.cssSelector(".input-group__addon")).click();
        logger.info("Ввели почту, нажали отправить приглашение");
    }

    public void inputResult(String message) {
        String actualMessage = driver.findElement(By.cssSelector("div.invite__modal > p:nth-child(3)")).getText();
        assertThat(actualMessage, containsString(message));
        logger.info("Проверили ожидаемое сообщение - " + actualMessage);
    }

    public void errorInvite() {
        String actualError = driver.findElement(By.cssSelector("p.input-line__error")).getText();
        assertThat(actualError, containsString("Неправильный Email-адрес"));
        logger.info("Проверили ожидаемое сообщение - " + actualError);
    }

    public void succesInvite() {
        String succesMessage = driver.findElement(By.cssSelector("p.input-line")).getText();
        assertThat(succesMessage, containsString("Приглашение отправлено!"));
        logger.info("Проверили ожидаемое сообщение - " + succesMessage);
    }

    //Personal data

    public void enterName() {
        driver.findElement(By.id("id_fname")).clear();
        driver.findElement(By.id("id_fname")).sendKeys("Anna");
        logger.info("Ввод имени");
    }

    public void enterLastName() {
        driver.findElement(By.id("id_lname")).clear();
        driver.findElement(By.id("id_lname")).sendKeys("NoName");
        logger.info("Ввод фамилии");
    }

    public void enterBlogName() {
        driver.findElement(By.id("id_blog_name")).clear();
        driver.findElement(By.id("id_blog_name")).sendKeys("BlogNoName");
        logger.info("Ввод имени для блога");
    }

    public void saveChanges() {
        driver.findElement(By.xpath("//button[@title='Сохранить и заполнить позже']")).click();
        logger.info("Сохранение изменений");
    }

    public void successSaving() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.cssSelector("span.success"), "Данные успешно сохранены"));
        logger.info("Данные успешно сохранены");
    }

    public void assertData() {
        String actualName = driver.findElement(By.cssSelector(".lk-cv-show__name")).getText();
        assertThat(actualName, containsString("Anna NoName"));
        logger.info("Проверка изменения");
    }

    public void chooseGender(String gender) {
        String xPath = "//option[@value='%s']";
        driver.findElement(By.id("id_gender")).click();
        driver.findElement(By.xpath(String.format(xPath, gender))).click();
        logger.info("Выбор пола пользователя");
    }

    public void enterCompanyName() {
        driver.findElement(By.id("id_company")).sendKeys("Some Company");
        logger.info("Ввод названия компании");
    }

    public void enterTitlePosition() {
        driver.findElement(By.id("id_work")).sendKeys("Some Position");
        logger.info("Ввод занимаемой должности");
    }

}
