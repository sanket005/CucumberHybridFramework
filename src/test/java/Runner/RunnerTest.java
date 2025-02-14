package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"html:D:\\CucumberFramework\\target\\Report.html"},//"pretty"},
				 publish=true,
	features="src\\test\\resources\\Feature\\LoginTestCase.feature",
			glue= {"StepDefinations","Hooks"}
)
public class RunnerTest {

}
