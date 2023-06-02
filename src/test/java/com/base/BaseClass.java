package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqSpec;
	Response response;

	/**
	 * @author Santhanam
	 * @param key,value
	 * @see this method is used to add header
	 * @since 27-05-23
	 */
	public void addHeader(String key, String value) {

		reqSpec = RestAssured.given();

	}

	/**
	 * @author Santhanam
	 * @param headers
	 * @see this method is used to add multiple headers
	 * @since 27-05-23
	 */

	public void addHeaders(Headers headers) {

		reqSpec = RestAssured.given().headers(headers);
	}

	/**
	 * @author Santhanam
	 * @param username, password
	 * @see this method is used to pass the username and password
	 * @since 27-06-23
	 */
	public void addBasicAuth(String username, String password) {

		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}

	/**
	 * @author Santhanam
	 * @param key, value
	 * @see this method is used to add path parameter
	 * @since 27-05-23
	 */
	public void addPathParam(String key, String value) {

		reqSpec.pathParam(key, value);
	}

	/**
	 * @author Santhanam
	 * @param key, value
	 * @see this method is used to add query parameter
	 * @since 27-05-23
	 */

	public void addQueryParam(String key, String value) {

		reqSpec.queryParam(key, value);
	}

	/**
	 * @author Santhanam
	 * @param body
	 * @see this method is used to add body for request
	 * @since 27-05-23
	 */
	public void addBody(Object body) {
		reqSpec.body(body);
	}

	/**
	 * @author Santhanam
	 * @param type, endpoint
	 * @see this method is used to add request type and endpoints
	 * @since 27-05-23
	 */

	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "PATCH":
			response = reqSpec.log().all().patch(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	/**
	 * @author Santhanam
	 * @param response
	 * @see this method is used to get the status code
	 * @since 27-05-23
	 */

	public int getStatusCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;
	}

	/**
	 * @author Santhanam
	 * @param response
	 * @see this method is used to get the response body
	 * @since 27-05-23
	 */

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	/**
	 * @author Santhanam
	 * @param response
	 * @see this method is used to get the response body as pretty format
	 * @since 27-05-23
	 */

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	/**
	 * @author Santhanam
	 * @see this method is used to get the project path
	 * @since 27-05-23
	 */

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "/config/config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

}
