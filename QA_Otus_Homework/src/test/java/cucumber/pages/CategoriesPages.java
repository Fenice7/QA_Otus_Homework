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

public class CategoriesPages {

    private Logger logger = LogManager.getLogger(CategoriesPages.class);
    private final WebDriver driver;

    public CategoriesPages() {
        driver = Driver.getDriver();
    }

    public void checkCoursesNumber(int numberOfCourses) {
        String courses = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.title-new__info-item"))).getText();
        logger.info("Сохранение количества курсов - " + courses);
        int actualNumber = Integer.parseInt(courses.replaceAll("[^0-9]", ""));
        logger.info("Извление числа из стороки = " + actualNumber);
        java.util.Objects.equals(actualNumber, numberOfCourses);
        logger.info("Сравнение значений");
    }

    public void checkPageHeadline(String section) {
        String actualHeadline = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1"))).getText();
        logger.info("Сохранение заголовка страницы - " + actualHeadline);
        assertThat(actualHeadline, containsString(section));
        logger.info("Проверка соответствия заголовка");
    }

    public void checkActiveNavItem(String section) {
        String activeItem = driver.findElement(By.cssSelector(".course-categories__nav-item_active")).getText();
        logger.info("Сохранение активного пункта меню - " + activeItem);
        assertThat(activeItem, containsString(section));
    }


}
