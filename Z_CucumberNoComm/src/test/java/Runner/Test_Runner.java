package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "src/test/java/features/Login.feature", // feature file path
		glue = "Steps"									   // step defination
		)

public class Test_Runner { }