package cucumber.steps;

import cucumber.pages.CategoriesPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CategoriesStepdefs {

    CategoriesPages categoriesPages = new CategoriesPages();

    @Then("Page title corresponds to {}")
    public void pageTitleCorrespondsTo(String section) {
        categoriesPages.checkPageHeadline(section);

    }

    @And("Navigation item {} active")
    public void navigationItemActive(String section) {
        categoriesPages.checkActiveNavItem(section);
    }

    @Then("I have to see that the {}")
    public void iHaveToSeeThatTheNumberOfCourses(int numberOfCourses) {
        categoriesPages.checkCoursesNumber(numberOfCourses);
    }
}
