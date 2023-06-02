package com.payloads.product;

import com.pojo.product.SearchProduct_Input_Pojo;

/**
 * @author Santhanam
 * @see this class is used to add the search product payload to the request body
 * @since 26-05-23
 */
public class ProductPayload {

	/**
	 * @author Santhanam
	 * @param data
	 * @see this method is used to add the search product payload to the request
	 *      body
	 * @return the search product payload
	 * @since 26-05-23
	 */
	public SearchProduct_Input_Pojo searchProductPayload(String data) {

		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(data);

		return searchProduct_Input_Pojo;

	}

}
