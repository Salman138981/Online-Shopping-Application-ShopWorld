package com.masaischool.service;

import java.util.List;

import com.masaischool.dao.ProductDAO;
import com.masaischool.dao.ProductDAOImpl;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;

public class ProductServiceImpl implements ProductService{
   
	@Override
	public void addProduct(Product product) throws  ProductException{
		
		ProductDAO pdao = new ProductDAOImpl();
		pdao.addProduct(product);
		
	
	}
	
	@Override
	public List<Product> getAllProducts() throws ProductException, NoRecordFoundException{
		ProductDAO pdao = new ProductDAOImpl();
		return pdao.getAllProducts();
		
	}
	
	@Override
	public void deleteProduct(int productId) throws ProductException, NoRecordFoundException{
		ProductDAO pdao = new ProductDAOImpl();
		pdao.deleteProduct(productId);
		
	}
	
	@Override
	public void updateProductPrice(int productId, double price) throws ProductException, NoRecordFoundException{
		ProductDAO pdao = new ProductDAOImpl();
		pdao.updateProductPrice(productId, price);
	}
	
	@Override
	public Product getAnProduct(int productId) throws ProductException, NoRecordFoundException{
		ProductDAO pdao = new ProductDAOImpl();
		return pdao.getProduct(productId);
	}
}
