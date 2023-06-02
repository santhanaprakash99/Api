package com.payloads.address;

import com.pojo.address.CityList_Input_Pojo;

public class CityPayload {

	public CityList_Input_Pojo cityListPayload(String stateId) {

		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateId);

		return cityList_Input_Pojo;

	}

}
