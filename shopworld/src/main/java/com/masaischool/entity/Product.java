package com.masaischool.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int productId;
	  
	  @Column(nullable = false, length=50)
	  private String productName;
	  
	  @Column(nullable = false, length=50)
	  private double price;
	  
	  @Column(nullable = false, length=50)
	  private String color;
	  
	  @Column(nullable = false, length=50)
	  private String dimension;
	  
	  @Column(nullable = false, length=50)
	  private String specification;
	  
	  @Column(nullable = false, length=50)
	  private String manufacturer;
	  
	  @Column(nullable = false)
	  private int Quantity;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, double price, String color, String dimension, String specification,
			String manufacturer, int quantity, Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		Quantity = quantity;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	  
	  
}
