package com.masaischool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int catId;
	 
	 @Column(nullable = false, length = 50)
	 private String categoryName;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	 
	 
	 
}
