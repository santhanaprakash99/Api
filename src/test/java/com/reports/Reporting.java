package com.reports;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

public class Reporting extends BaseClass {

	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		getProjectPath();
		getPropertyFileValue(jsonFile);

	}
}