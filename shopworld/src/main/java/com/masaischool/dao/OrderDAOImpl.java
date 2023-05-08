package com.masaischool.dao;

import com.masaischool.entity.Orders;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class OrderDAOImpl implements OrderDAO{
  
	@Override
	public void addOrder(Orders order) throws SomethingWentWrongException{
		EntityManager em = EMUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(order);			
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("unable to add Order");
		}finally {
			et.commit();
			em.close();			
		}
	}
}
