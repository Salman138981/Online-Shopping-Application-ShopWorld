package com.masaischool.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int cartId;
	 
	 
	  @OneToOne(cascade = CascadeType.ALL)
	  private Customer customer;
	  
	  @OneToMany(cascade = CascadeType.ALL)
	  //@JoinColumn(name = "cart_productId")
	  private List<Product> productlist;
	  
	 

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Customer customer, List<Product> productlist) {
		super();
		this.customer = customer;
		this.productlist = productlist;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	  
	  
}
