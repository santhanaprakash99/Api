
package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {

	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expStatusCode) {
		int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
		Assert.assertEquals("verify status code", expStatusCode, actStatusCode);

	}

}
