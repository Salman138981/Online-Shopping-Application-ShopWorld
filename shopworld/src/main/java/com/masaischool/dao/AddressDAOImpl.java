package com.masaischool.dao;

import com.masaischool.entity.Address;
import com.masaischool.entity.Customer;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AddressDAOImpl implements AddressDAO{
   
	@Override
	public Address getAddressById(int addressId) throws NoRecordFoundException, SomethingWentWrongException{
		EntityManager em = null;
		 Address address= null;
		try {
			em = EMUtils.getAnEntityManager();
		   String query = "SELECT a FROM Address a WHERE a.addressId = :addressId";
		   Query que = em.createQuery(query);
		   que.setParameter("addressId",addressId);
		   
		    address =(Address) que.getSingleResult();
		    
		    if(address==null) {
		    	throw new NoRecordFoundException("No address found with with "+ addressId );
		    }
			
			
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return address;	
	}
}
