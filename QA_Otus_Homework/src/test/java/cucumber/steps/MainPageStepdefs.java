package cucumber.steps;

import config.ServerConfig;
import cucumber.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPageStepdefs {

    MainPage mainPage = new MainPage();
    private Logger logger = LogManager.getLogger(MainPageStepdefs.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Given("I open the main page")
    public void iOpenTheMainPage() {
        mainPage.openSite();
    }

    @Then("I compare the current title with the expected one")
    public void iCompareTheCurrentTitleWithTheExpectedOne() {
        mainPage.compareTitle();
    }

    @When("I click on button Login and Registration")
    public void iClickOnButtonLoginAndRegistration() {
        mainPage.clickOnRegisterButton();
    }

    @And("I enter email")
    public void iEnterEmail() {
        mainPage.enterEmail();
    }

    @And("I enter password")
    public void iEnterPassword() {
        mainPage.enterPassword();
    }

    @And("I click button Login")
    public void iClickButtonLogin() {
        mainPage.clickLogin();
    }

    @Then("I see button My courses")
    public void iSeeButtonMyCourses() {
        mainPage.waitButtonMyCourses();

    }

    @And("I enter fail mail")
    public void iEnterFailEmail() {
        mainPage.enterFailEmail();
    }

    @And("I enter fail pass")
    public void iEnterFailPassword() {
        mainPage.enterFailPass();
    }

    @Then("I see error message")
    public void iSeeErrorMessage() {
        mainPage.checkLoginError();
    }

    @And("I go to the Knowledge Base menu section")
    public void iGoToTheKnowledgeBaseMenuSection() {
        mainPage.goToKnowledgeSection();
    }


    @And("I open Personal Area page")
    public void iOpenPersonalAreaPage() {
        mainPage.openLK();
    }

    @When("I go to the {}")
    public void iGoToTheSection(String section) {
        mainPage.goToNavItem(section);
    }
}
