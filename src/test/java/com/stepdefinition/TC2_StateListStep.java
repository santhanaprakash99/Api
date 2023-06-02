package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * @author Santhanam
 * @see State module API Automation
 * @since 02-06-23
 *
 */

public class TC2_StateListStep extends BaseClass {
	Response response;
	public static String stateId;

	@Given("User add headers for the statelist")
	public void user_add_headers_for_the_statelist() {

		addHeader("accept", "application/json");

	}

	/**
	 * @author Santhanam
	 * @param reqType
	 * @see this method is used to send request for statelist endpoint
	 * @since 02-06-23
	 */

	@When("User send {string} request for statelist endpoint")
	public void user_send_request_for_statelist_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @author Santhanam
	 * @param expStateName
	 * @see this method is used to verify the statelist response message matches
	 *      with expected message
	 * @since 02-06-23
	 */

	@Then("User verify the statelist response message matches {string} and save state id")
	public void user_verify_the_statelist_response_message_matches_and_save_state_id(String expStateName) {

		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<StateList> data = stateList_Output_Pojo.getData();
		for (StateList state : data) {

			String name = state.getName();

			if (name.equals(expStateName)) {

				int stateid = state.getId();
				stateId = String.valueOf(stateid);
				System.out.println(stateId);
				TC1_LoginStep.globalDatas.setStateId(stateId);
				Assert.assertEquals("verify state name", expStateName, name);
				break;

			}

		}
	}

}
