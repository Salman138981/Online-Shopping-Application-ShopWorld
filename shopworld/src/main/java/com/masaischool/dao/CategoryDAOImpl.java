package com.masaischool.dao;

import com.masaischool.entity.Category;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class CategoryDAOImpl implements CategoryDAO{
	
	@Override
	public void addCategory(Category category) throws SomethingWentWrongException{
		EntityManager em = EMUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(category);			
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("unable to add Category");
		}finally {
			et.commit();
			em.close();			
		}
		
	}
}
