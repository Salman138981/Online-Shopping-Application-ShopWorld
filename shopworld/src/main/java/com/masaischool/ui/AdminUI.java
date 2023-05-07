package com.masaischool.ui;

import java.util.List;
import java.util.Scanner;

import com.masaischool.entity.Category;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.CategoryService;
import com.masaischool.service.CategoryServiceImpl;
import com.masaischool.service.ProductService;
import com.masaischool.service.ProductServiceImpl;

public class AdminUI {
	
	public static void viewProduct(Scanner sc) {
		System.out.println("Enter Product Id: ");
		int productId = sc.nextInt();
		
		try{
			ProductService ps = new ProductServiceImpl();
			Product  product =ps.getAnProduct(productId);
			
			System.out.println(product);
			
			
		}catch(ProductException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updatePrice(Scanner sc) {
		System.out.println("Enter Product Id: ");
		int productId = sc.nextInt();
		System.out.println("Enter new Price: ");
		double price = sc.nextDouble();
		
		
		try{
			ProductService ps = new ProductServiceImpl();
			ps.updateProductPrice(productId, price);
			System.out.println("Price Updated Successfully");
			
		}catch(ProductException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		 
	}
	
	public static void removeProduct(Scanner sc) {
		System.out.println("Enter product id: ");
		int productId = sc.nextInt();
		
		System.out.print("Are you sure you want to delete product?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				ProductService ps = new ProductServiceImpl();
				ps.deleteProduct(productId);
				System.out.println("Product has been removed Successfully");			
			}catch(ProductException | NoRecordFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public static void vewAllProducts() {
		try {
		ProductService ps = new ProductServiceImpl();
		
		  List<Product> list =ps.getAllProducts();
		  
		  list.stream().forEach( product -> System.out.println("The product name is: "+ product.getProductName()  + " price is: "
				  + product.getPrice()+" color is: " + product.getColor() + " dimension is: " + product.getDimension() + " specification : "+ product.getSpecification()
				  + " manufacturer: " + product.getManufacturer() + " quantity : " + product.getQuantity() + " category: " + product.getCategory().getCategoryName()));
		}
		catch(ProductException | NoRecordFoundException e){
			System.out.println(e.getMessage());
		}
	}
 
    public static void addProduct(Scanner sc) {
    	System.out.println("Enter Product Name: ");
    	String productName = sc.next();
    	System.out.println("Set Price: ");
    	double price = sc.nextDouble();
    	System.out.println("Enter Color");
        String color = sc.next();
        System.out.println("Enter dimension");
        String dimension = sc.next();
        
        System.out.println("Enter Specification: ");
        String specification = sc.next();
        
        System.out.println("Enter manufacturer: ");
        String manufacturer = sc.next();
        
        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();
        
        System.out.println("Enter category name:");
        String categoryName = sc.next();
        
        try {
        	
        	Category category = new Category(categoryName);
        	Product product = new Product(productName,price,color,dimension, specification,manufacturer,quantity,category);
        	
        	ProductService ps = new ProductServiceImpl();
        	
        	ps.addProduct(product);
        	
        	System.out.println("Product Added Successfully");
        }
        catch(ProductException p) {
        	System.out.println(p.getMessage());
        	
        }
        
        
    }
    
    public static void addCategory(Scanner sc) {
    	
    	System.out.println("Enter Cateory Name:");
    	String categoryName = sc.next();
    	
    	try {
    		
    		Category category = new Category(categoryName);
    		
    		CategoryService cs = new CategoryServiceImpl();
    		
    		cs.addCategory(category);
    	   System.out.println("Categroy added Successfully");
    	}catch(SomethingWentWrongException e) {
    		System.out.println(e.getMessage());
    	}
    }
	
}
