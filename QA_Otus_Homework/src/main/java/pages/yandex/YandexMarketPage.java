package pages.yandex;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YandexMarketPage {

    private WebDriver driver;

    public YandexMarketPage(WebDriver driver) {
        this.driver = driver;
    }


    private By electron = By.xpath(".//span[text()='Электроника']");
    private By smartphone = By.xpath("//*[text()='Смартфоны']");
    private By samsungFilter = By.xpath("//*[@id='search-prepack']//span[text()='Samsung']");
    private By xiaomiFilter = By.xpath("//div[@data-filter-value-id='7701962']//span[text()='Xiaomi']");
    private By sortAPrice = By.xpath("//button[text()='по цене']");
    private By favorites = By.xpath("//div[@data-zone-name='snippetWishlistToggler']");
    private By firstArticle = By.xpath("//div[@data-zone-name='SearchResults']//article[1]//h3");
    private By buttonCompare = By.xpath("//*[text()='Сравнить']");

    public void jumpToElectronSection() {
        driver.findElement(electron).click();
        new WebDriverWait(driver, 15)
        .until(ExpectedConditions.textToBe(By.cssSelector("h1"), "Электроника"));
    }

    public void jumpToSmartphoneSection() {
        driver.findElement(smartphone).click();
    }

    public void sortPrice() {
        driver.findElement(sortAPrice).click();
    }

    public void filterSamsungCompany(String company){
        String filterXpath = "//span[text()='%s']";
        driver.findElement(By.xpath(String.format(filterXpath, company))).click();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);

        }

    }

    public void addToCompare(String name) {
        String compareXpath = "//span[contains(text(),'%s')]";
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(String.format(compareXpath, name)))).pause(1000l).perform();
        driver.findElement(By.cssSelector("div._1CXljk9rtd")).click();
        new WebDriverWait(driver, 15)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Сравнить']")));
    }

    public String getFirstArticleTitle() {
        return driver.findElement(By.xpath("//div[@data-zone-name='SearchResults']//article[1]//h3")).getText();
    }

    public String getTextCompare() {
        return driver.findElement(By.cssSelector("div._1_ABPFjOJQ")).getText();
    }

    public void goToComparePage() {
        driver.findElement(buttonCompare).click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.textToBe(By.cssSelector("._2itQJaiEj2"), "Сравнение товаров"));
    }

    public List<WebElement> compareList() {
        return (List<WebElement>) driver.findElements(By.xpath("//*[@class='LwwocgVx0q _2VGDFjE-Ev']"));
    }


}
