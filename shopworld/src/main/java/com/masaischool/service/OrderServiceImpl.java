package com.masaischool.service;

import java.util.List;

import com.masaischool.dao.OrderDAO;
import com.masaischool.dao.OrderDAOImpl;
import com.masaischool.entity.Orders;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class OrderServiceImpl implements OrderService {
  
	@Override
	public void addOrder(Orders order) throws SomethingWentWrongException{
		
		OrderDAO o = new OrderDAOImpl();
		
		o.addOrder(order);
	}
	
	@Override
	public Orders displayOrder(int orderId) throws SomethingWentWrongException, NoRecordFoundException{
		OrderDAO o = new OrderDAOImpl();
		
		return o.displayOrder(orderId);
	}
	
	@Override
	public void updateStatus(int orderId, String status) throws SomethingWentWrongException, NoRecordFoundException{
		OrderDAO o = new OrderDAOImpl();
		
		o.updateStatus(orderId,status);
	}
	
	@Override
	public List<Orders> displayAllOrders() throws SomethingWentWrongException, NoRecordFoundException{
		OrderDAO o = new OrderDAOImpl();
		
		return o.displayAllOrders();
	}
	
	@Override
	public void deleteOrder(int orderId) throws SomethingWentWrongException, NoRecordFoundException{
		OrderDAO o = new OrderDAOImpl();
		
		o.deleteOrder(orderId);
	}
}
