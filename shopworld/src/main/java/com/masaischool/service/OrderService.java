package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Orders;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface OrderService {
  
	
	public void addOrder(Orders order) throws SomethingWentWrongException;
	
	public Orders displayOrder(int orderId) throws SomethingWentWrongException, NoRecordFoundException;
	
	public void updateStatus(int orderId, String status) throws SomethingWentWrongException, NoRecordFoundException;
	
	public List<Orders> displayAllOrders() throws SomethingWentWrongException, NoRecordFoundException;
	
	public void deleteOrder(int orderId) throws SomethingWentWrongException, NoRecordFoundException;
}
