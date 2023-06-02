package com.payloads.address;

import com.pojo.address.CityList_Input_Pojo;

/**
 * @author Santhanam
 * @see this class is used to add the citypayload
 * @since 27-05-23
 */
public class CityPayload {

	/**
	 * @author Santhanam
	 * @param stateId
	 * @see this method is used to add the citylist payload the request body
	 * @return the citylist
	 * @since 27-05-23
	 */
	public CityList_Input_Pojo cityListPayload(String stateId) {

		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateId);

		return cityList_Input_Pojo;

	}

}
