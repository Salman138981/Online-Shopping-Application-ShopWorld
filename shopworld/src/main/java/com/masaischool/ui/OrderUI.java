package com.masaischool.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masaischool.entity.Address;
import com.masaischool.entity.Customer;
import com.masaischool.entity.Orders;
import com.masaischool.entity.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.ProductException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.AddressService;
import com.masaischool.service.AddressServiceImpl;
import com.masaischool.service.CustomerService;
import com.masaischool.service.CustomerServiceImpl;
import com.masaischool.service.OrderService;
import com.masaischool.service.OrderServiceImpl;
import com.masaischool.service.ProductService;
import com.masaischool.service.ProductServiceImpl;

public class OrderUI {
     
	public static void addOrder(Scanner sc) {
		 System.out.println("Enter Order Date:");
		 LocalDate orderDate = LocalDate.parse(sc.next());
		 System.out.println("Enter Order Status: ");
		 String status = sc.next();
		 System.out.println("Enter customer password:");
		 String password = sc.next();
		 System.out.println("Enter address Id:");
		 int addressId = sc.nextInt();
		 
		 CustomerService cs = new CustomerServiceImpl();
		 Customer customer=null;
		try {
			customer = cs.viewCustomer(password);
		} catch (SomethingWentWrongException e1) {
			System.out.println(e1.getMessage());
		} catch (NoRecordFoundException e1) {
			System.out.println(e1.getMessage());
		}
		 
		 ProductService ps = new ProductServiceImpl();
		 List<Product> productlist= null;
		try {
			productlist = ps.getAllProducts();
		} catch (ProductException e1) {
			System.out.println(e1.getMessage());
		} catch (NoRecordFoundException e1) {
			System.out.println(e1.getMessage());
		}
		 
		 AddressService as = new AddressServiceImpl();
		 Address address=null;
		try {
			address = as.getAddressById(addressId);
		} catch (NoRecordFoundException | SomethingWentWrongException e1) {
			System.out.println(e1.getMessage());
		}
		 
		 Orders order = new Orders(orderDate,status,null,null,null);
		 order.setCustomer(customer);
		 order.setProductList(productlist);
		 order.setAddress(address);
		 
		 OrderService os = new OrderServiceImpl();
		 
		 try {
			os.addOrder(order);
			System.out.println("order Added Successfully");
			
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		 
	}
}
