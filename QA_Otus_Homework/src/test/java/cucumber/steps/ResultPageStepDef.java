package cucumber.steps;

import cucumber.pages.ResultPage;
import io.cucumber.java.en.And;

public class ResultPageStepDef {

    ResultPage resultPage = new ResultPage();

    @And("I choose tab Blogs")
    public void iChooseTabBlogs() {
        resultPage.iChooseTabBlogs();
    }

    @And("I select found blog in result page")
    public void iSelectFoundBlogInResultPage() {
        resultPage.selectBlogInResultPage();
    }

}
