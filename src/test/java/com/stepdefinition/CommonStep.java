
package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;

/**
 * @author Santhanam
 * @see this class is used to reduce the code redundancy
 * @since 02-06-23
 *
 */
public class CommonStep extends BaseClass {

	/**
	 * @author Santhanam
	 * @see this method is used to verify the status code matches with expected
	 *      status code
	 * @since 02-06-23
	 *
	 */

	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expStatusCode) {
		int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
		Assert.assertEquals("verify status code", expStatusCode, actStatusCode);

	}

}
