package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.manager.PayloadManager;
import com.pojo.address.CityList;
import com.pojo.address.CityList_Input_Pojo;
import com.pojo.address.CityList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends BaseClass {

	Response response;
	public static String cityId;
	PayloadManager manager = new PayloadManager();

	@Given("User add headers for the citylist")
	public void user_add_headers_for_the_citylist() {

		List<Header> listHeadres = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listHeadres.add(h1);
		listHeadres.add(h2);

		Headers headers = new Headers(listHeadres);
		addHeaders(headers);

	}

	@When("User add request body for citylist {string}")
	public void user_add_request_body_for_citylist(String stateId) {
		CityList_Input_Pojo cityListPayload = manager.getCityPayload()
				.cityListPayload(TC1_LoginStep.globalDatas.getStateId());
		addBody(cityListPayload);
	}

	@When("User send {string} request for citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.CITYLIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User verify the citylist response message matches {string} and save city id")
	public void user_verify_the_citylist_response_message_matches_and_save_city_id(String expCityName) {
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);

		ArrayList<CityList> data = cityList_Output_Pojo.getData();
		for (CityList cityList : data) {

			String name = cityList.getName();
			if (name.equals(expCityName)) {
				int id = cityList.getId();
				cityId = String.valueOf(id);
				System.out.println(cityId);
				TC1_LoginStep.globalDatas.setCityId(cityId);
				Assert.assertEquals("verify city name", expCityName, name);
				break;

			}

		}

	}

}
