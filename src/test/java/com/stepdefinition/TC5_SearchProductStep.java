package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payloads.product.ProductPayload;
import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass {

	Response response;

	@Given("User add headers for accessing searchProduct endpoint")
	public void user_add_headers_for_accessing_searcha_product_endpoint() {
		List<Header> listHeaders = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

	}

	@When("User add request body for search product {string}")
	public void user_add_request_body_for_search_product(String product) {

		SearchProduct_Input_Pojo searchProductPayload =ProductPayload.searchProductPayload("nuts");
		addBody(searchProductPayload);

	}

	@When("User send {string} request for searchaProduct endpoint")
	public void user_send_request_for_searcha_product_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify the searchProduct response matches with {string}")
	public void user_should_verify_the_search_product_response_matches_with(String expMessage) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String message = searchProduct_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals("verify success message",expMessage,message );
	}

}
