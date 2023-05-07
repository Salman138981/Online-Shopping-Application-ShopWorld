package com.masaischool.service;

import com.masaischool.entity.Category;
import com.masaischool.exception.SomethingWentWrongException;

public interface CategoryService {
    
	
	public void addCategory(Category category) throws SomethingWentWrongException;
}
