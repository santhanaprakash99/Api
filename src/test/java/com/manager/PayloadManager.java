package com.manager;

import com.payloads.address.AddressPayload;
import com.payloads.address.CityPayload;
import com.payloads.product.ProductPayload;

public class PayloadManager {

	private AddressPayload addressPayload;
	private ProductPayload productPayload;
	private CityPayload cityPayload;

	public AddressPayload getAddressPayload() {
		return (addressPayload == null) ? addressPayload = new AddressPayload() : addressPayload;
	}

	public ProductPayload getProductPayload() {

		return (productPayload == null) ? productPayload = new ProductPayload() : productPayload;
	}

	public CityPayload getCityPayload() {

		return (cityPayload == null) ? cityPayload = new CityPayload() : cityPayload;
	}

}
