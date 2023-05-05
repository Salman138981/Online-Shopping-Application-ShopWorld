package com.masaischool.ui;

import java.util.Scanner;

import com.masaischool.entity.Address;
import com.masaischool.entity.Customer;
import com.masaischool.entity.LoggedInUserId;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.CustomerService;
import com.masaischool.service.CustomerServiceImpl;

public class CustomerUI {
   
	public static void customerRegistration(Scanner sc) {
		 
		System.out.println("Enter First Name: ");
		String firstName = sc.next();
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		System.out.println("Enter Email: ");
		String email= sc.next();
		System.out.println("Enter Mobile Number: ");
		String mobileNumber = sc.next();
		
		
		System.out.println("Enter street Number: ");
		String streetNo = sc.next();
		System.out.println("Enter Building Name: ");
		String buildingName  = sc.next();
		System.out.println("Enter City: ");
		String city = sc.next();
		System.out.println("Enter State: ");
		String state = sc.next();
		System.out.println("Enter Country: ");
		String country = sc.next();
		System.out.println("Enter pincode: ");
		String pincode= sc.next();
		Address address = new Address(streetNo,buildingName,city,state,country,pincode);
		int isDeleted = 0;
		
		Customer customer = new Customer(firstName,lastName,username,password,email,mobileNumber,isDeleted,address);
		
		try {
			
			CustomerService cs = new CustomerServiceImpl();
			cs.addCustomer(customer);
			System.out.println("Customer added successfully");
		}catch(SomethingWentWrongException e){
			System.out.println(e.getMessage());
		}		
		
		
	}
	
	static void displayUserMenu() {
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. Change Password");
		System.out.println("7. Delete Account");
		System.out.println("0. Logout");
	}
	public static void userMenu(Scanner sc) {
		int choice = -1;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				//this code is same as we have used on the admin side
    				//so we are using here as it is
    				
    				break;
    			case 2:
    				
    				break;
    			case 3:
    			
    				break;
    			case 4:
    			
    				break;
    			case 5:
    				
    				break;
    			case 6:
    				changePassword(sc);
    				break;
    			case 7:
    				deleteAccount(sc);
    				System.out.println("Logging you out");
    				choice = 0;
    			case 0:
    				LoggedInUserId.loggedInUserId = -1;	//-1 id cannot belong to any customer
    				System.out.println("Bye Bye User");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
	
	}
	
     static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			userMenu(sc);
		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		} 	
	}
     
     public static void changePassword(Scanner sc) {
    	System.out.print("Enter old password ");
 		String oldPassword = sc.next();
 		System.out.print("Enter new password ");
 		String newPassword = sc.next();
 		System.out.print("Re-Enter new password ");
 		String reEnterNewPassword = sc.next();
 		
 		if(!newPassword.equals(reEnterNewPassword)) {
 			System.out.println("New password and Re-Entered password mismtached");
 			return ;
 		}
 		else if(oldPassword.equals(reEnterNewPassword)) {
 			System.out.println("New password and old password must be different");
 			return;
 		}
 		
 		try {
 			CustomerService customerService = new CustomerServiceImpl();
 			customerService.changePassword(oldPassword, reEnterNewPassword);
 			System.out.println("Password updated successfully");
 		}catch(SomethingWentWrongException e) {
 			System.out.println(e.getMessage());
 		}
     }
     
     public static void deleteAccount(Scanner sc) {
    	 System.out.print("Are you sure you want to delete your account?[y/n] ");
 		char choice = sc.next().toLowerCase().charAt(0);
 		if(choice == 'y') {
 			try {
 				CustomerService customerService = new CustomerServiceImpl();
 				customerService.deleteAccount();
 				System.out.println("Its really sad to see you go, As per your request account is deleted");			
 			}catch(SomethingWentWrongException ex) {
 				System.out.println(ex.getMessage());
 			}
 		}
     }
}
