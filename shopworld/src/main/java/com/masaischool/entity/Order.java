package com.masaischool.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Order {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int orderId;
	  
	 @Column(nullable = false )	
	 private LocalDate orderDate;
	 
	 @Column(length = 50, nullable = false)
	 private String orderStatus;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 private Customer customer;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<Product> productList;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 private Address address;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(LocalDate orderDate, String orderStatus, Customer customer, List<Product> productList,
			Address address) {
		super();
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.productList = productList;
		this.address = address;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	 
	 
	 
}
