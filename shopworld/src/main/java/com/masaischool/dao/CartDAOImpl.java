package com.masaischool.dao;

import java.util.ArrayList;
import java.util.List;

import com.masaischool.entity.Address;
import com.masaischool.entity.Cart;
import com.masaischool.entity.Customer;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class CartDAOImpl implements CartDAO{
   
	@Override
	public void addProductToCart(Cart cart, Product product, int quantity) throws SomethingWentWrongException {
	    EntityManager em = EMUtils.getAnEntityManager();
	    EntityTransaction et = em.getTransaction();
	    try {
	        et.begin();

	        Customer customer = cart.getCustomer();
	        if (customer != null && customer.getCustomerId() != 0) {
	            cart.setCustomer(em.merge(customer));
	        }

	        List<Product> products = cart.getProductlist();
	        if (products == null) {
	            products = new ArrayList<>();
	        }

	        boolean productExists = false;
	        for (Product p : products) {
	            if (p.getProductId() == product.getProductId()) {
	                p.setQuantity(quantity);
	                productExists = true;
	                break;
	            }
	        }

	        if (!productExists) {
	            product.setQuantity(quantity);
	            products.add(product);
	        }

	        cart.setProductlist(products);
	        em.merge(cart);
	        et.commit();
	        System.out.println("Product added to cart successfully");
	    } catch (PersistenceException ex) {
	        et.rollback();
	        ex.printStackTrace();
	        throw new SomethingWentWrongException("Unable to add product to cart");
	    } finally {
	        em.close();
	    }
	}


	@Override
	public void removeProductFromCart(Cart cart, int productId) throws SomethingWentWrongException,NoRecordFoundException {
	    EntityManager em = null;
	    Product product=null;
	    try {
	        em = EMUtils.getAnEntityManager();
	        EntityTransaction et = em.getTransaction();
	       
	        et.begin();
	        
	        
	        
	        
	        
	            List<Product> productList = cart.getProductlist();
	            
	            for(Product p : productList) {
	            	if(p.getProductId()==productId) {
	            	     product  = em.find(Product.class, productId);	
	            	}
	            	else {
	            		throw new NoRecordFoundException("No product found");
	            	}
	            }
	            em.remove(product);
	            et.commit();
	     
	           
	    } catch (PersistenceException ex) {
	        throw new SomethingWentWrongException("Unable to remove the product from the cart, please try again later");
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}




}
