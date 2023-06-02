package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags=("@Login or @State or @City or @Address or @@SearchProduct"),features = "src/test/resources/Features/", glue = "com.stepdefinition", plugin = {
		"pretty", "json:target/output.json" }, dryRun = false, monochrome = true)

public class TestRunner extends BaseClass {

	@AfterClass
	public static void afterScenerio() throws FileNotFoundException, IOException {

		Reporting.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonpath"));

	}

}
