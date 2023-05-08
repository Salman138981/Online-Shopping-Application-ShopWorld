package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;

public interface ProductDAO {
  
	public void addProduct(Product product) throws  ProductException;
	public List<Product>  getAllProducts() throws ProductException, NoRecordFoundException;
	public void deleteProduct(int productId) throws ProductException, NoRecordFoundException;
	
	public void updateProductPrice(int productId, double price) throws ProductException, NoRecordFoundException;
	public Product getProduct(int productId) throws ProductException, NoRecordFoundException;
}
