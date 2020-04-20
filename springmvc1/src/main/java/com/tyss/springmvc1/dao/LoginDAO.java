package com.tyss.springmvc1.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.springmvc1.beans.Login;
import com.tyss.springmvc1.beans.EmployeeInfoBean;

public class LoginDAO implements LoginDAOI{
	
		@Override
		public String authenticate(Login login) {
			EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("employeePersistenceUnit");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
		        // get an user object
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
		      Login login1 = entityManager.find(Login.class, 1);
		        // commit transaction
		      
		      String un = login1.getUsername();
		      String pd = login1.getPassword();
//		      entityTransaction.commit();
		      if ((un.equals(login.getUsername()))&&(pd.equals(login.getPassword()))) {
			return "true";
		} else {
			return "false";
		}
		
	}
}
