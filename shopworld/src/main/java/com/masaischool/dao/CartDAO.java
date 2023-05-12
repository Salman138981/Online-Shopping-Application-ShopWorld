package com.masaischool.dao;

import com.masaischool.entity.Cart;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface CartDAO {
 
	
	public void addProductToCart(Cart cart, Product product, int quantity) throws SomethingWentWrongException;
	public void removeProductFromCart(Cart cart, int productId) throws SomethingWentWrongException,NoRecordFoundException;
}
