package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\dhinesh\\eclipse-workspace\\CucumberSeleniumJava\\src\\test\\resources\\features\\login.feature",
    glue = {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner {
	
	///
}
