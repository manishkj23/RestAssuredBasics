package com.test.APIUtils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
//                plugin = "json:target/jsonReports/cucumber-report.json",
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/cucumber.json","rerun:target/rerun.txt","usage:target/cucumber-usage.json"},
                glue={"classpath:com/test/StepDefinition"}
)
public class TestRunner {






}
