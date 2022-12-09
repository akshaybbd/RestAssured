package com.RestAssuredFramework.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features/", glue = { "com.RestAssuredFramework.StepDefination" })
public class RunnerClass extends AbstractTestNGCucumberTests {

}
