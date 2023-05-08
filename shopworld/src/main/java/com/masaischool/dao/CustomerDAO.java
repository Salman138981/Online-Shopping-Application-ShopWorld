package com.masaischool.dao;

import com.masaischool.entity.Customer;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface CustomerDAO {
   
	public void addCustomer(Customer customer) throws SomethingWentWrongException;
	
	public void login(String username,String password) throws NoRecordFoundException, SomethingWentWrongException;
	public void changePassword(String oldPassword, String reEnterNewPassword) throws SomethingWentWrongException;
   
	public void deleteAccount() throws SomethingWentWrongException;
    
	public Customer getCustomer(String password) throws SomethingWentWrongException,NoRecordFoundException;
	
}
