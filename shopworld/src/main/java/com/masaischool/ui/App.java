package com.masaischool.ui;

import java.util.Scanner;

public class App{
	
	static void displayAdminMenu() {
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. ");
		System.out.println("7. ");
		System.out.println("8. ");
		System.out.println("9. ");
		System.out.println("10. ");
		System.out.println("0. Logout");
	}

	static void adminMenu(Scanner sc) {
		int choice = -1;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				
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
    				
    				break;
    			case 7:
    				
    				break;
    			case 8:
    				
    				break;
    			case 9:
    				
    				break;
    			case 10:
    				
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	
	public static void adminLogin(Scanner sc) {
		System.out.println("Enter username ");
		String username = sc.next();
		System.out.println("Enter password ");
		String password = sc.next();
		
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
			
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				CustomerUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services, Visit again");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
        
    }
}
