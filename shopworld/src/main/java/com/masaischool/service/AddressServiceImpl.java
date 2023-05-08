package com.masaischool.service;

import com.masaischool.dao.AddressDAO;
import com.masaischool.dao.AddressDAOImpl;
import com.masaischool.entity.Address;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class AddressServiceImpl implements AddressService{
	
	@Override
 	public Address getAddressById(int addressId) throws NoRecordFoundException, SomethingWentWrongException{
		
		AddressDAO a = new AddressDAOImpl();
		
		return a.getAddressById(addressId);
	}
}
