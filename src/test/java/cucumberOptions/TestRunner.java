package cucumberOptions;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



// @RunWith(Cucumber.class) - Only for Cucumber JUnit runner
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests{

}
