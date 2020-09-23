package com.lti.ui;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.RegisteredUserTicket;
import com.lti.model.UserTbl;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager=factory.createEntityManager();
		
		UserTbl obj1=new UserTbl("abcde@mail.com", "Abc", "A", "B", "9836285622",new Date(), "Male");
		UserTbl obj2=new UserTbl("abcd@mail.com", "Abcd", "A", "B", "9836285622",new Date(), "Male");

		RegisteredUserTicket reg1=new RegisteredUserTicket();	
		RegisteredUserTicket reg2=new RegisteredUserTicket();	
		RegisteredUserTicket reg3=new RegisteredUserTicket();	
		
		obj1.setRegisterTicket(new HashSet<RegisteredUserTicket>());
		
		obj1.addTicket(reg1);
		obj1.addTicket(reg2);
		
		obj2.setRegisterTicket(new HashSet<RegisteredUserTicket>());
		
		obj2.addTicket(reg3);
		entityManager.getTransaction().begin();
		entityManager.persist(obj1);
		entityManager.persist(obj2);
		entityManager.getTransaction().commit();
		
	}

}
