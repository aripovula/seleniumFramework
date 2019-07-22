package cucumberAutom;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue="stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
