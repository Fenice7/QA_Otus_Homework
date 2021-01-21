package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTests.json",
                "junit:target/cucumber-reports/CucumberTests.xml",
                "html:target/cucumber-reports/index.html"},
        features = {"src/test/resources/features"},
        glue = {"cucumber"},
        tags = "@parameter"
)

public class CucumberRunTest {


}
