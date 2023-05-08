package com.masaischool.service;

import com.masaischool.entity.Cart;
import com.masaischool.entity.Product;
import com.masaischool.exception.SomethingWentWrongException;

public interface CartService {
   
	public void addProductToCart(Cart cart, Product product, int quantity) throws SomethingWentWrongException;
}
