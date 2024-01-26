package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        //path for feature files
        features = "src/test/resources/features/",
        //path to the implementation of gherkin steps
        glue = "steps",
        dryRun = false,
        //specify the tag for which you are running tests like smoke/regression etc
        tags = "@search",
        //reports
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json", "rerun:target/failed.txt"}
        //rerun plugin will create failed.txt under target for all failed tc
)
public class RunnerClass {
}
