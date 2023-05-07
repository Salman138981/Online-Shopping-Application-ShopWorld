package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ProductDAOImpl  implements ProductDAO{
   
	@Override
	public void addProduct(Product product) throws ProductException{
		EntityManager em = EMUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(product);			
		}catch(PersistenceException ex) {
			throw new ProductException("unable to add product");
		}finally {
			et.commit();
			em.close();			
		}
	}
	
	@Override
	public List<Product> getAllProducts() throws ProductException, NoRecordFoundException{
		
		EntityManager em = null;
		List<Product> list =null;
		try {
			em =  EMUtils.getAnEntityManager();
			String query = "SELECT p FROM Product p";
			
			
			Query que = em.createQuery(query);
			
			list = (List<Product>)que.getResultList();
			
			if(list.size() ==0) {
				throw new NoRecordFoundException("No Product Found");
			}
			
		}catch(IllegalArgumentException p) {
			throw new ProductException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		return list;
	}
	
	@Override
	public void deleteProduct(int productId) throws ProductException, NoRecordFoundException{
		EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			
			Product product =em.find(Product.class, productId);
			
			if(product ==null) {
			    throw new NoRecordFoundException("No Product Found with given Product id: "+ productId);
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(product);
			et.commit();
			
		}catch(PersistenceException ex) {
			throw new ProductException("Unable to delete product, try again later");
		}finally{
			em.close();
		}
	}
	
	@Override
	public void updateProductPrice(int productId, double price) throws ProductException, NoRecordFoundException{
		EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			
			Product product =em.find(Product.class, productId);
			
			if(product ==null) {
			    throw new NoRecordFoundException("No Product Found with given Product id: "+ productId);
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			product.setPrice(price);
			et.commit();
			
		}catch(PersistenceException ex) {
			throw new ProductException("Unable to update product Price, try again later");
		}finally{
			em.close();
		}
	}
	
	@Override
	public Product getProduct(int productId) throws ProductException, NoRecordFoundException{
		EntityManager em = null;
	    Product product;
		try {
			em = EMUtils.getAnEntityManager();
			
			product =em.find(Product.class, productId);
			
			if(product ==null) {
			    throw new NoRecordFoundException("No Product Found with given Product id: "+ productId);
			}
			
				
		}catch(PersistenceException ex) {
			throw new ProductException("Unable to update product Price, try again later");
		}finally{
			em.close();
		}
		return product;
	}
}
