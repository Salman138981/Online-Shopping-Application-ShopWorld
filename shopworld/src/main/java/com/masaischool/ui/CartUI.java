package com.masaischool.ui;

import java.util.List;
import java.util.Scanner;

import com.masaischool.entity.Cart;
import com.masaischool.entity.Customer;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.CartService;
import com.masaischool.service.CartServiceImpl;
import com.masaischool.service.ProductService;
import com.masaischool.service.ProductServiceImpl;

public class CartUI {
   
	public static void removeProductFromCart(Scanner sc) {
	
		System.out.println("Enter your password");
    	String password= sc.next();
    	
    	System.out.println("Enter Product Id:");
    	int productId = sc.nextInt();
    	
    	
    	Customer customer = CustomerUI.viewCustomerByPassword(password);
    	ProductService ps = new ProductServiceImpl();
    	
    	
    	
    	try {
    		
    		
			List<Product> productlist=null;
			try {
				productlist = ps.getAllProducts();
			} catch (ProductException e1) {
				
				e1.printStackTrace();
			}
			Cart cart = new Cart(customer,productlist);
			
			CartService cartService = new CartServiceImpl();
			
			try {
				cartService.removeProductFromCart(cart,productId);
			} catch (SomethingWentWrongException e) {
				System.out.println(e.getMessage());
				
			}
			
    	}
    	 catch (NoRecordFoundException e) {
			System.out.println(e.getMessage());
			
		
    	}
	}
}
