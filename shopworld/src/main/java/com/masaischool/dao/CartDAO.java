package com.masaischool.dao;

import com.masaischool.entity.Cart;
import com.masaischool.entity.Product;
import com.masaischool.exception.SomethingWentWrongException;

public interface CartDAO {
 
	
	public void addProductToCart(Cart cart, Product product, int quantity) throws SomethingWentWrongException;
}
