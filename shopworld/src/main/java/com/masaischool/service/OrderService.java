package com.masaischool.service;

import com.masaischool.entity.Orders;
import com.masaischool.exception.SomethingWentWrongException;

public interface OrderService {
  
	
	public void addOrder(Orders order) throws SomethingWentWrongException;
}
