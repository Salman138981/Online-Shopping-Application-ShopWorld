package com.masaischool.service;

import com.masaischool.dao.OrderDAO;
import com.masaischool.dao.OrderDAOImpl;
import com.masaischool.entity.Orders;
import com.masaischool.exception.SomethingWentWrongException;

public class OrderServiceImpl implements OrderService {
  
	@Override
	public void addOrder(Orders order) throws SomethingWentWrongException{
		
		OrderDAO o = new OrderDAOImpl();
		
		o.addOrder(order);
	}
}
