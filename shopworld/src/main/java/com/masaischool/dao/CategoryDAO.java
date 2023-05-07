package com.masaischool.dao;

import com.masaischool.entity.Category;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public interface CategoryDAO {
	
	public void addCategory(Category category) throws SomethingWentWrongException;
		
	
}