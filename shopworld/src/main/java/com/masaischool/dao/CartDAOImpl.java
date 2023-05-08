package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Cart;
import com.masaischool.entity.Product;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class CartDAOImpl implements CartDAO{
   
	    @Override
		public void addProductToCart(Cart cart, Product product, int quantity) throws SomethingWentWrongException {
			EntityManager em = null;
			boolean productFound= false;
			
			
			try {
				
				em = EMUtils.getAnEntityManager();
				
				EntityTransaction et = em.getTransaction();
				et.begin();
				List<Product> list = cart.getProductlist();
				
				for( Product p : list) {
					 if(p.getProductId() == product.getProductId()) {
						 p.setQuantity(p.getQuantity()+ quantity);
						 System.out.println("product already exist in the cart, so quantity is updated");
						 productFound = true;
						 break;
					 }
				}
				
				if(!productFound){
					cart.getProductlist().add(product);
					em.merge(cart);
				     em.persist(cart);
				     System.out.println("Product added to cart Successfully");
					
				}
				et.commit();
				
			}catch(PersistenceException ex) {
				throw new SomethingWentWrongException("uable to add product to cart, try again later");
			}
			finally {
				em.close();
			}
	
	
			
		}
}
