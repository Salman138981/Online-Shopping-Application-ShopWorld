package com.masaischool.service;

import com.masaischool.dao.CartDAO;
import com.masaischool.dao.CartDAOImpl;
import com.masaischool.entity.Cart;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class CartServiceImpl implements CartService{
	
	@Override
	public void addProductToCart(Cart cart, Product product, int quantity) throws SomethingWentWrongException {
		 
		CartDAO cartDAO = new CartDAOImpl();
		cartDAO.addProductToCart(cart,product,quantity);
	}
	
	@Override
	public void removeProductFromCart(Cart cart,int productId) throws SomethingWentWrongException,NoRecordFoundException{
		CartDAO cartDAO = new CartDAOImpl();
		cartDAO.removeProductFromCart(cart,productId);
	}

}
