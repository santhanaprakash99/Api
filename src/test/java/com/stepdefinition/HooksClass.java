package com.stepdefinition;


import org.junit.After;

import com.base.BaseClass;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;

/**
 * @author Santhanam
 * @see this class is used to reduce the code redundancy
 * @since 02-06-2023
 *
 */
public class HooksClass extends BaseClass {
	
	Scenario scenario;
	Response response;
	
	@After
	public void afterScenario(Scenario sc) {
		
		scenario = sc;
		
		scenario.log(getResBodyAsPrettyString(response));

	}
	
	
	

}
