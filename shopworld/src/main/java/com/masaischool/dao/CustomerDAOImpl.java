package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Customer;
import com.masaischool.entity.LoggedInUserId;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO{
    
	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			
			String query = "SELECT count(c) FROM Customer c WHERE username = :username";
			Query que = em.createQuery(query);
			que.setParameter("username", customer.getUsername());
			
		
			
			if((Long)que.getSingleResult() > 0)  {
				throw new SomethingWentWrongException("The username " + customer.getUsername() + " is already occupied");
			}
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.persist(customer);
			et.commit();
		
			
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally {
			
			em.close();
		}
	}
	
	@Override
	public void login(String username,String password) throws NoRecordFoundException, SomethingWentWrongException{
		EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			Query query = em.createQuery("SELECT c.id FROM Customer c WHERE username = :username AND password = :password AND isDeleted = 0");
     
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			List<Integer> list = query.getResultList();
			
			if(list.size() == 0) {
				throw new NoRecordFoundException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = list.get(0);
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}
		finally {
			em.close();
		}
	}
	
	@Override
	public void changePassword(String oldPassword, String NewPassword) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE c.password = :oldPassword AND c.id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", LoggedInUserId.loggedInUserId);
			
			long users =(long)query.getSingleResult();
			
			if(users ==0) {
				throw new SomethingWentWrongException("Invalid old password");
			}
			
			Customer customer  = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			
			EntityTransaction et= em.getTransaction();
			
			et.begin();
			customer.setPassword(NewPassword);
			et.commit();
			
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}
		finally {
			em.close();
		}
	}
	
	@Override
	public void deleteAccount() throws SomethingWentWrongException{
		EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setIsDeleted(1);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

}
