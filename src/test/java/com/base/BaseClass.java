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

	public void addHeader(String key, String value) {

		reqSpec = RestAssured.given();

	}

	public void addHeaders(Headers headers) {

		reqSpec = RestAssured.given().headers(headers);
	}

	public void addBasicAuth(String username, String password) {

		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}

	public void addPathParam(String key, String value) {

		reqSpec.pathParam(key, value);
	}

	public void addQueryParam(String key, String value) {

		reqSpec.queryParam(key, value);
	}

	public void addBody(Object body) {
		reqSpec.body(body);
	}

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

	public int getStatusCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

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
