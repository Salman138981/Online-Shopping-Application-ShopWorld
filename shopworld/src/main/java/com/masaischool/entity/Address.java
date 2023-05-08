package com.masaischool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int addressId;
  
  @Column(nullable = false, length= 50)
  private String streetNo;
  
  @Column(nullable = false, length= 50)
  private String buildingName;
  
  @Column(nullable = false, length= 50)
  private String city;
  
  @Column(nullable = false, length= 50)
  private String state;
  
  @Column(nullable = false, length= 50)
  private String country;
  
  @Column(nullable = false, length= 50)
  private String pincode;

 public Address() {
	super();
	// TODO Auto-generated constructor stub
}

public Address(String streetNo, String buildingName, String city, String state, String country, String pincode) {
	super();
	this.streetNo = streetNo;
	this.buildingName = buildingName;
	this.city = city;
	this.state = state;
	this.country = country;
	this.pincode = pincode;
}

public int getAddressId() {
	return addressId;
}

public void setAddressId(int addressId) {
	this.addressId = addressId;
}

public String getStreetNo() {
	return streetNo;
}

public void setStreetNo(String streetNo) {
	this.streetNo = streetNo;
}

public String getBuildingName() {
	return buildingName;
}

public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

@Override
public String toString() {
	return "addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName + ", city="
			+ city + ", state=" + state + ", country=" + country + ", pincode=" + pincode;
} 
  
 
 
  
  
}
