package com.masaischool.dao;

import com.masaischool.entity.Orders;
import com.masaischool.exception.SomethingWentWrongException;

public interface OrderDAO {
  
	public void addOrder(Orders order) throws SomethingWentWrongException;
}
