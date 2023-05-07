package com.masaischool.service;

import com.masaischool.dao.CustomerDAO;
import com.masaischool.dao.CustomerDAOImpl;
import com.masaischool.entity.Customer;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException{
		 
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.addCustomer(customer);
	}
	
	@Override
	public void login(String username, String password) throws NoRecordFoundException, SomethingWentWrongException{
		
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.login(username,password);
		
	}
	
	@Override
	public void changePassword(String oldPassword, String reEnterNewPassword) throws SomethingWentWrongException {
		
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.changePassword(oldPassword,reEnterNewPassword);
	}

	@Override
	public void deleteAccount() throws SomethingWentWrongException{
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.deleteAccount();
	}
	
	@Override
	public Customer viewCustomer(String password) throws SomethingWentWrongException,NoRecordFoundException{
		CustomerDAO cDAO = new CustomerDAOImpl();
		return cDAO.getCustomer(password);
	}

}
