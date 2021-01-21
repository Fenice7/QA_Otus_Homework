package cucumber.steps;

import cucumber.pages.LkPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LkStepdefs {

    LkPage lkPage = new LkPage();

    @Given("I am opening the section invite a friend")
    public void iAmOpeningTheSectionInviteAFriend() {
        lkPage.openInviteSection();
    }

    @When("I enter {} in input")
    public void iEnterEmailInInput(String email) {
        lkPage.enterEmailInInput(email);
    }

    @Then("I see an informational {}")
    public void iSeeAnInformationalMessage(String message) {
        lkPage.inputResult(message);
    }

    @Then("I see an error message")
    public void iSeeAnErrorMessage() {
        lkPage.errorInvite();
    }

    @Then("I see an succes message")
    public void iSeeAnSuccesMessage() {
        lkPage.succesInvite();
    }

    //Personal data

    @Given("I enter data in the field name")
    public void iEnterDataInTheFieldName() {
        lkPage.enterName();
    }

    @And("I enter data in the field last name")
    public void iEnterDataInTheFieldLastName() {
        lkPage.enterLastName();
    }

    @And("I enter data in the field blog name")
    public void iEnterDataInTheFieldBlogName() {
        lkPage.enterBlogName();
    }

    @And("Save changes")
    public void saveChanges() {
        lkPage.saveChanges();
    }

    @Then("Confirmation of successful save")
    public void confirmationofSuccessfulSave() {
        lkPage.successSaving();
    }

    @And("Assert enter data")
    public void assertEnterData() {
        lkPage.assertData();
    }

    @Given("I choose {string} in select")
    public void iChooseGender(String gender) {
        lkPage.chooseGender("f");
    }

    @And("I enter the name of the company")
    public void iEnterTheNameOfTheCompany() {
        lkPage.enterCompanyName();
    }

    @And("I enter the title of the position")
    public void iEnterTheTitleOfThePosition() {
        lkPage.enterTitlePosition();
    }


}
