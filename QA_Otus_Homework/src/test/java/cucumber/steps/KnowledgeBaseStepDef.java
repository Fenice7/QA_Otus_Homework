package cucumber.steps;

import cucumber.pages.KnowledgeBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class KnowledgeBaseStepDef {

    KnowledgeBasePage knowledgeBasePage = new KnowledgeBasePage();


    @When("I search {string}")
    public void iSearch(String blogName) {
       knowledgeBasePage.searchBarInput(blogName);
    }

    @And("I click found")
    public void iClickFound() {
        knowledgeBasePage.clickFind();
    }

}
