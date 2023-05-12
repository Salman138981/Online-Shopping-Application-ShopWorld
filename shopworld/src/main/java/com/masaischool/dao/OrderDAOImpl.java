package com.masaischool.dao;

import java.util.ArrayList;
import java.util.List;

import com.masaischool.entity.Address;
import com.masaischool.entity.Customer;
import com.masaischool.entity.Orders;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class OrderDAOImpl implements OrderDAO{
  
//	@Override
//	public void addOrder(Orders orders) throws SomethingWentWrongException{
//		EntityManager em = EMUtils.getAnEntityManager();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		try {
//			em.persist(orders);			
//		}catch(PersistenceException ex) {
//			//throw new SomethingWentWrongException("unable to add Order");
//			ex.printStackTrace();
//		}finally {
//			et.commit();
//			em.close();			
//		}
//	}
	
	@Override
	public void addOrder(Orders orders) throws SomethingWentWrongException {
	    EntityManager em = EMUtils.getAnEntityManager();
	    EntityTransaction et = em.getTransaction();
	    try {
	        et.begin();
	        Customer customer = orders.getCustomer();
	        if (customer != null && customer.getCustomerId() != 0) {
	            orders.setCustomer(em.merge(customer));
	        }
	        Address address = orders.getAddress();
	        if (address != null && address.getAddressId() != 0) {
	            orders.setAddress(em.merge(address));
	        }
	        List<Product> products = orders.getProducts();
	        if (products != null) {
	            List<Product> mergedProducts = new ArrayList<>();
	            for (Product product : products) {
	                if (product.getProductId() != 0) {
	                    mergedProducts.add(em.merge(product));
	                } else {
	                    mergedProducts.add(product);
	                }
	            }
	            orders.setProductList(mergedProducts);
	        }
	        em.persist(orders);
	        et.commit();
	        System.out.println("Order added successfully");
	    } catch (PersistenceException ex) {
	        et.rollback();
	        throw new SomethingWentWrongException("Unable to add Order");
	    } finally {
	        em.close();
	    }
	}
	
	@Override
	public Orders displayOrder(int orderId) throws SomethingWentWrongException, NoRecordFoundException{
		EntityManager em = null;
	    Orders order;
		try {
			em = EMUtils.getAnEntityManager();
			
			order =em.find(Orders.class, orderId);
			
			if(order ==null) {
			    throw new NoRecordFoundException("No Order Found with given Product id: "+ orderId);
			}
			
				
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to fetch orderDetails Price, try again later");
		}finally{
			em.close();
		}
		return order;
	}
	

  @Override
  public void updateStatus(int orderId, String status) throws SomethingWentWrongException, NoRecordFoundException{
	  EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			
			Orders order =em.find(Orders.class, orderId);
			
			if(order ==null) {
			    throw new NoRecordFoundException("No order Found with given order id: "+ orderId);
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			order.setOrderStatus(status);
			et.commit();
			
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to update order status, try again later");
		}finally{
			em.close();
		}  
  }
  
  @Override
  public List<Orders> displayAllOrders() throws SomethingWentWrongException, NoRecordFoundException{
	  EntityManager em = null;
		List<Orders> list =null;
		try {
			em =  EMUtils.getAnEntityManager();
			String query = "SELECT o FROM Orders o";
			
			
			Query que = em.createQuery(query);
			
			list = (List<Orders>)que.getResultList();
			
			if(list.size() ==0) {
				throw new NoRecordFoundException("No Product Found");
			}
			
		}catch(IllegalArgumentException p) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		return list;
  }
  
  @Override
  public void deleteOrder(int orderId) throws SomethingWentWrongException, NoRecordFoundException{
	  EntityManager em = null;
		try {
			em = EMUtils.getAnEntityManager();
			
			Orders order =em.find(Orders.class, orderId);
			
			if(order ==null) {
			    throw new NoRecordFoundException("No Order Found with given Order id: "+ orderId);
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(order);
			et.commit();
			
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to delete order, try again later");
		}finally{
			em.close();
		}	  
  }
}


