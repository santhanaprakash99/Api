package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.globals.GlobalDatas;
import com.pojo.login.Login_Output_pojo;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

/**
 * @author Santhanam
 * @see Login module API Automation
 * @since 02-06-23
 *
 */
public class TC1_LoginStep extends BaseClass {
	Response response;
	static GlobalDatas globalDatas = new GlobalDatas();

	@Given("Use  add header")
	public void use_add_header() {

		addHeader("accept", "application/json");
	}

	/**
	 * @author Santhanam
	 * @throws FileNotFoundException ,IOException
	 * @see this method is used to add basic authentication for login
	 * @since 02-06-23
	 * 
	 */

	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {

		addBasicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));

	}

	/**
	 * @author Santhanam
	 * @param reqType
	 * @see this method is used to send request for login endpoint
	 * @since 02-06-23
	 */

	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String reqType) {

		response = addReqType(reqType, Endpoints.POSTMANBASICAUTH);

		int statusCode = getStatusCode(response);
		globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @author Santhanam
	 * @param expfirstName
	 * @see this method is used to verify the login response body firstName present
	 *      as expected first name
	 * @since 02-06-23
	 */

	@Then("User verify the login response body firstName present as {string} and get the logtoken")
	public void user_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken(String expfirstName) {

		Login_Output_pojo asLogin = response.as(Login_Output_pojo.class);

		String actfirstName = asLogin.getData().getFirst_name();
		System.out.println(actfirstName);
		Assert.assertEquals("verify firstName", expfirstName, actfirstName);
		TC1_LoginStep.globalDatas.setLogtoken(asLogin.getData().getLogtoken());
	}

}
