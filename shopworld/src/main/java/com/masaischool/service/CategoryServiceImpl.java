package com.masaischool.service;

import com.masaischool.dao.CategoryDAO;
import com.masaischool.dao.CategoryDAOImpl;
import com.masaischool.entity.Category;
import com.masaischool.exception.SomethingWentWrongException;

public class CategoryServiceImpl implements CategoryService {
   
	public void addCategory(Category category) throws SomethingWentWrongException{
		
		CategoryDAO cdao = new CategoryDAOImpl();
		
		cdao.addCategory(category);
		
	}
}
