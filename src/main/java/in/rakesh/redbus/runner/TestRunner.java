package in.rakesh.redbus.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/features/redbus-bdd.feature",
		glue="in.rakesh.redbus.glue"
		)
public class TestRunner {

	
	
}
