package allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;


import java.io.ByteArrayInputStream;

public class Page {

    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    private By acceptButton = By.xpath("//span[text()='Принимаю']");


    @Step("Open google.com")
    public void openPage() {
        driver.get("https://www.google.ru/");

    }

    @Step("Entering a search query")
    public void searchByRequest(String request) {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(request, Keys.ENTER);
        Allure.addAttachment("searchByRequest", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
