package com.masaischool.ui;

import com.masaischool.entity.Address;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.AddressService;
import com.masaischool.service.AddressServiceImpl;

public class AddressUI {
    
	public static Address getAddressById(int addressId) {
		Address address = null;
	    try {
	    	AddressService as = new AddressServiceImpl();
	    	address =as.getAddressById(addressId);
	    	
	    	System.out.println(address);
	      
	    }catch(NoRecordFoundException | SomethingWentWrongException e) {
	    	System.out.println(e.getMessage());
	    }
	    return address;
	}
}
