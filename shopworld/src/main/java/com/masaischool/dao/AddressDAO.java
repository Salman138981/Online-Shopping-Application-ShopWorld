package com.masaischool.dao;

import com.masaischool.entity.Address;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface AddressDAO {

	
	public Address getAddressById(int addressId) throws NoRecordFoundException, SomethingWentWrongException;
} 
