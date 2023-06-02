package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.manager.PayloadManager;
import com.pojo.address.UpdateUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.useraddress;
import com.pojo.address.DeleteAddress_Output_Pojo;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Santhanam
 * @see Address module API Automation
 * @since 02-06-23
 */
public class TC4_AddressStep extends BaseClass {
	Response response;
	int address_id;
	public static String addressId;
	PayloadManager manager = new PayloadManager();

	@Given("User add header and bearer authorization for accessing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoint() {

		List<Header> listHeadres = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeadres.add(h1);
		listHeadres.add(h2);
		listHeadres.add(h3);

		Headers headers = new Headers(listHeadres);

		addHeaders(headers);

	}

	/**
	 * @author Santhanam
	 * @param firstName, lastName, String mobile, apartment, state, city, country,
	 *                   zipcode, address, address_type
	 * @see this method is used to add request body for new address
	 * 
	 * @since 02-06-23
	 */

	@When("User add request body for new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_new_address_and(String firstName, String lastName, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		AddUserAddress_Input_Pojo addAddressPayload = manager.getAddressPayload().addAddressPayload(firstName, lastName,
				mobile, apartment, Integer.parseInt(TC1_LoginStep.globalDatas.getStateId()),
				Integer.parseInt(TC1_LoginStep.globalDatas.getCityId()), Integer.parseInt(country), zipcode, address,
				address_type);
		addBody(addAddressPayload);
	}

	/**
	 * @author Santhanam
	 * @param reqType
	 * @see this method is used to send request for addUserAddress endpoint
	 * @since 02-06-23
	 */

	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {

		response = addReqType(reqType, Endpoints.ADDUSERADDRESS);

		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @author Santhanam
	 * @see this method is used to verify the addUserAddres response matches with
	 *      expected message and save the address id
	 * @since 02-06-23
	 */

	@Then("User should verify the addUserAddres response matches with {string} and save the address_id")
	public void user_should_verify_the_add_user_addres_response_matches_with_and_save_the_address_id(
			String expMessage) {

		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);

		String message = addUserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals("verify success message", expMessage, message);
		int address_id = addUserAddress_Output_Pojo.getAddress_id();
		addressId = String.valueOf(address_id);
		TC1_LoginStep.globalDatas.setaddressId(addressId);

	}

	@Given("User add headers  for accessing updateAddress endpoint")
	public void user_add_headers_for_accessing_update_address_endpoint() {
		List<Header> listHeadres = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeadres.add(h1);
		listHeadres.add(h2);
		listHeadres.add(h3);

		Headers headers = new Headers(listHeadres);

		addHeaders(headers);

	}

	/**
	 * @author Santhanam
	 * @param addressIdString, firstName, lastName, mobile, apartment, state, city,
	 *                         country, zipcode, address, addressType
	 * @see this method is used to add request body for for new address id
	 * @since 02-06-23
	 */

	@When("User add request body for new address id  {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_new_address_id_and(String addressId, String firstName, String lastName,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String addressType) {

		UpdateUserAddress_Input_Pojo updateUserAddressPayload = manager.getAddressPayload().updateUserAddressPayload(
				TC1_LoginStep.globalDatas.getaddressId(), firstName, lastName, mobile, apartment,
				Integer.parseInt(TC1_LoginStep.globalDatas.getStateId()),
				Integer.parseInt(TC1_LoginStep.globalDatas.getCityId()), Integer.parseInt(country), zipcode, address,
				addressType);
		addBody(updateUserAddressPayload);
	}

	/**
	 * @author Santhanam
	 * @param reqType
	 * @see this method is used to add request for updateUserAddress endpoin
	 * @since 02-06-23
	 */

	@When("User send {string} request for updateUserAddress endpoint")
	public void user_send_request_for_update_user_address_endpoint(String reqType) {

		response = addReqType(reqType, Endpoints.UPDATEUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @author Santhanam
	 * @param expMessage
	 * @see this method is used to verify the updateUserAddress response matches
	 *      with expected message
	 * @since 02-06-23
	 */

	@Then("User should verify the updateUserAddress response matches with {string}")
	public void user_should_verify_the_update_user_address_response_matches_with(String expMessage) {

		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);

		String message = updateUserAddress_Output_Pojo.getMessage();

		System.out.println(message);

		Assert.assertEquals("verify success message", expMessage, message);

	}

	@Given("User add header and bearer authorization for accessing getUserAddress endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_get_user_address_endpoint() {
		List<Header> listHeadres = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());

		listHeadres.add(h1);
		listHeadres.add(h2);

		Headers headers = new Headers(listHeadres);
		addHeaders(headers);
	}

	/**
	 * @author Santhanam
	 * @param addressId
	 * @see this method is used to add request for getUserAddress endpoint
	 * @since 02-06-23
	 */

	@When("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @author Santhanam
	 * @param addressId
	 * @see this method is used to verify the getUserAddress response city name
	 *      matches with expected message
	 * @since 02-06-23
	 */

	@Then("User should verify the getUserAddress response city name matches with {string}")
	public void user_should_verify_the_get_user_address_response_city_name_matches_with(String expCityName) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		ArrayList<useraddress> data = getUserAddress_Output_Pojo.getData();
		for (useraddress useraddress : data) {
			String city = useraddress.getCity();

			if (city.equals(expCityName)) {
				System.out.println(city);
				Assert.assertEquals("verify city name", expCityName, city);

			}

		}
	}

	@Given("User add header and bearer authorization for accessing deleteAddress endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_delete_address_endpoint() {
		List<Header> listHeadres = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeadres.add(h1);
		listHeadres.add(h2);
		listHeadres.add(h3);

		Headers headers = new Headers(listHeadres);

		addHeaders(headers);

	}

	/**
	 * @author Santhanam
	 * @param addressId
	 * @see this method is used to add request body for delete the existing address
	 * @since 02-06-23
	 */
	@When("User add request body for delete the existing {string}")
	public void user_add_request_body_for_delete_the_existing(String addressId) {

		DeleteAddress_Input_Pojo deleteAddresspayload = manager.getAddressPayload()
				.deleteAddresspayload(TC1_LoginStep.globalDatas.getaddressId());
		addBody(deleteAddresspayload);
	}

	/**
	 * @author Santhanam
	 * @param reqType
	 * @see this method is used to send request for deleteUserAddress endpoint
	 */
	@When("User send {string} request for deleteUserAddress endpoint")
	public void user_send_request_for_delete_user_address_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.DELETEUSERADDRESS);

		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @author Santhanam
	 * @param expMessage
	 * @see this method is used to verify the deleteUserAddress response matches
	 *      with expected message
	 */
	@Then("User should verify the deleteUserAddress response matches with {string}")
	public void user_should_verify_the_delete_user_address_response_matches_with(String expMessage) {

		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteAddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify success message", expMessage, message);

	}

}