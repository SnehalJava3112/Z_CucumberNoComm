package A_Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "src/test/java/A_features/A_Login.feature", // feature file path
		glue = "A_Steps",									   // step defination
		//dryRun = false,									   	   // mapping step def with login.feature. true-> code not running,
															   // false (default) -> code running and giving missing method if any
		stepNotifications = true							   // step wise result status (false)
		)

public class A_Test_Runner {}
