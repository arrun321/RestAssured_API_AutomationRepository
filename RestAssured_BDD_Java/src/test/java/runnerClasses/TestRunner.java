package runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		glue =  "glueCode",
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true
	)
public class TestRunner {

	}

//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = "src/test/resources/functionalTests",
//		glue= {"stepDefinitions"},
//		plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml" },
//		monochrome = true
//	)
//
//public class TestRunner {
//
//}	
//		@RunWith(Cucumber.class)
//		@CucumberOptions(
//				plugin = { "html:target/cucumberHtmlReport", "json:target/cucumber-report.json" }, 
//				features = "src/test/resources/Features", 
//				glue =  "glueCode" 
//				//tags = {"@run"}
//				)
//		public class TestRunner {
//
//		}
		