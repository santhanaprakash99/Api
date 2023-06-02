package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author Santhanam
 * @see this class is used to generate the report
 * @since 26-05-23
 */
public class Reporting {

	/**
	 * @author Santhanam
	 * @param json
	 * @see this method is used to generate the jvm report
	 * @since 26-05-23
	 */
	public static void generateJvmReport(String json) {
		String path = System.getProperty("user.dir");

		File file = new File(path + "//target");

		Configuration configuration = new Configuration(file, "OmrBranch Report");

		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS", "Linux Mint");
		configuration.addClassifications("Sprint", "24");

		List<String> list = new ArrayList<String>();
		list.add(json);

		ReportBuilder builder = new ReportBuilder(list, configuration);
		builder.generateReports();
	}
}