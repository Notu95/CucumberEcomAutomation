package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
glue={"StepDefinations"},
monochrome=true
//,tags= "@smoke or @regression" 
//,plugin= {"pretty",
//		"junit:target/junitReports/report.xml",
//		"json:target/jsonReports/report.json",
//		"html:target/HtmlReports/"}
)
public class TestRunner {

}
  