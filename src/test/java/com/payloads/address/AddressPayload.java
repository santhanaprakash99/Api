package com.payloads.address;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.DeleteAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

/**
 * @author Santhanam
 * @see this class is used to add the payload for address module
 * @since 28-05-23
 */
public class AddressPayload {

	/**
	 * @author Santhanam
	 * @param firstName,lastName, mobile, apartment, state, city, country, zipcode,
	 *                            address, address_type
	 * @see this method is used to add the address payload to the request body
	 * @return the address payload
	 * @since 28-05-23
	 */

	public AddUserAddress_Input_Pojo addAddressPayload(String firstName, String lastName, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {

		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(firstName, lastName, mobile,
				apartment, state, city, country, zipcode, address, address_type);
		return addUserAddress_Input_Pojo;

	}

	/**
	 * @author Santhanam
	 * @param addressId
	 * @see this method is used to add the delete request payload to requst body
	 * @return the delete address payload
	 * @since 28-05-23
	 */

	public DeleteAddress_Input_Pojo deleteAddresspayload(String addressId) {

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(addressId);

		return deleteAddress_Input_Pojo;

	}

	/**
	 * @author Santhanam
	 * @param addressId,firstName,lastName, mobile, apartment, state, city, country,
	 *                                      zipcode, address, address_type
	 * @see this method is used to add the update address payload to the request
	 *      body
	 * @return the update address payload
	 * @since 28-05-23
	 */

	public UpdateUserAddress_Input_Pojo updateUserAddressPayload(String addressId, String firstName, String lastName,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String addressType) {

		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(addressId,
				firstName, lastName, mobile, apartment, state, city, country, zipcode, address, addressType);

		return updateUserAddress_Input_Pojo;
	}

}
