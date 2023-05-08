package com.masaischool.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int customerId;
  
  @Column(nullable = false, length= 50)	
  private String firstName;
  
  @Column(nullable = false, length=50)
  private String lastName;
  
  @Column(unique= true, length = 50, nullable = false)
  private String username;
  
  @Column(unique = true, length = 50, nullable= false)
  private String password;
  
  @Column(length= 50, nullable = false)
  private String email;
  
  @Column(nullable = false, length = 12)
  private String mobileNumber;
  
  @Column(name = "is_deleted", nullable = false)
  private int isDeleted;
  
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

public Customer(String firstName, String lastName, String username, String password, String email, String mobileNumber,
		 Address address) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	
	this.address = address;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public int getIsDeleted() {
	return isDeleted;
}

public void setIsDeleted(int isDeleted) {
	this.isDeleted = isDeleted;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
			+ username + ", password=" + password + ", email=" + email + ", mobileNumber=" + mobileNumber + ", address="
			+ address + "]";
}
  
  
  
}
