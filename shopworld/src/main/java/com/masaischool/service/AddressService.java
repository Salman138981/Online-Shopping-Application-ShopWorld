package com.masaischool.service;

import com.masaischool.entity.Address;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface AddressService {
  
	public Address getAddressById(int AddressId) throws NoRecordFoundException, SomethingWentWrongException;
}
