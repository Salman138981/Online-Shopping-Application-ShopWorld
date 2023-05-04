package com.masaischool.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
   
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("shopConnect");
	}
	
	
	public static EntityManager getAnEntityManager() {
		return emf.createEntityManager();
	}
}
