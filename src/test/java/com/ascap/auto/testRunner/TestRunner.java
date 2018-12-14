package com.ascap.auto.testRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", 
					"html:target/cucumber",
					"json:target/cucumber.json" }, 
		features = "src/test/resources/com/project/features/", 
		glue = "com/ascap/auto/test/StepDef/", 
		monochrome = true, 
		tags = {"@writer_US_resident_with_DD" }

)
public class TestRunner {

}