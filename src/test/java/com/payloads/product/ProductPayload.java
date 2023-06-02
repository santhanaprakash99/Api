package com.payloads.product;

import com.pojo.product.SearchProduct_Input_Pojo;

public class ProductPayload {

	public static SearchProduct_Input_Pojo searchProductPayload(String data) {

		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(data);

		return searchProduct_Input_Pojo;

	}

}
