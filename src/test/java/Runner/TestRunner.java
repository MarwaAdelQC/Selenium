package Runner;

import Tests.TestBase;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (features = "src/test/java/Features", glue = {"StepDefinitions"}, plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner extends TestBase {
	


}
