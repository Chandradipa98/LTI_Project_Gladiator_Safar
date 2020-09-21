package com.lti.ui;


import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.BusTbl;
import com.lti.model.Payment;
import com.lti.model.ReservationTbl;
import com.lti.model.SeatTbl;
import com.lti.model.UserTbl;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		UserTbl utb1 = new UserTbl("s@gmail.com", "Mani", "Nag", "9875522689", "mn29", new Date(), "female");
		UserTbl utb2 = new UserTbl("g@gmail.com", "Chandradipa", "Nag", "9775773152", "cn29", new Date(), "female");
		
		ReservationTbl res1 = new ReservationTbl(new Date(), 3, 'Y');
		ReservationTbl res2 = new ReservationTbl(new Date(), 2, 'Y');
		ReservationTbl res3 = new ReservationTbl(new Date(), 1, 'Y');
		
		ReservationTbl res4 = new ReservationTbl(new Date(), 1, 'Y');
		ReservationTbl res5 = new ReservationTbl(new Date(), 1, 'Y');
		
		BusTbl bus1 = new BusTbl(new Date(), new Date(), "Kolkata", "Pune", 350, 10, 20, 'Y', "10.30 a.m.", "10.30 p.m.");
		BusTbl bus2 = new BusTbl(new Date(), new Date(), "Kolkata", "Howrah", 100, 15, 20, 'Y', "11.00 a.m.", "12.00 p.m.");		
		BusTbl bus3 = new BusTbl(new Date(), new Date(), "Mumbai", "Delhi", 400, 12, 20, 'Y', "1.00 a.m.", "1.00 p.m.");
		
		Payment pay1 = new Payment(1000);
		Payment pay2 = new Payment(1000);
		Payment pay3 = new Payment(1000);
		Payment pay4 = new Payment(1000);
		Payment pay5 = new Payment(1000);
		
		res4.setEmailId("xyz@gmail.com");
		res5.setEmailId("xz@gmail.com");
		res4.setPhoneNo("9048434243");
		res5.setPhoneNo("9045623498");
		
		res1.setUser(utb1);
		res2.setUser(utb1);
		res3.setUser(utb2);
		
		SeatTbl seat11 = new SeatTbl(11);
		SeatTbl seat12 = new SeatTbl(12);
		SeatTbl seat13 = new SeatTbl(13);
		SeatTbl seat14 = new SeatTbl(14);
		SeatTbl seat15 = new SeatTbl(15);
		
		SeatTbl seat21 = new SeatTbl(21);
		SeatTbl seat22 = new SeatTbl(22);
		SeatTbl seat23 = new SeatTbl(23);
		SeatTbl seat24 = new SeatTbl(24);
		SeatTbl seat25 = new SeatTbl(25);
		
		SeatTbl seat31 = new SeatTbl(31);
		SeatTbl seat32 = new SeatTbl(32);
		SeatTbl seat33 = new SeatTbl(33);
		SeatTbl seat34 = new SeatTbl(34);
		SeatTbl seat35 = new SeatTbl(35);
		
		entityManager.getTransaction().begin();
		entityManager.persist(utb1);
		entityManager.persist(utb2);
		entityManager.persist(res1);
		entityManager.persist(res2);
		entityManager.persist(res3);
		entityManager.persist(res4);
		entityManager.persist(res5);
		
		res1.setEmailId(res1.getUser().getEmailId());
		res2.setEmailId(res2.getUser().getEmailId());
		res3.setEmailId(res3.getUser().getEmailId());
		
		res1.setPhoneNo(res1.getUser().getPhoneNo());
		res2.setPhoneNo(res2.getUser().getPhoneNo());
		res3.setPhoneNo(res3.getUser().getPhoneNo());
		
		res1.setBus(bus1);
		res2.setBus(bus2);
		res3.setBus(bus2);
		res4.setBus(bus3);
		res5.setBus(bus3);
		
		res1.setTotalFare(res1.getBus().getBaseFare()*res1.getNoOfSeats());
		res2.setTotalFare(res2.getBus().getBaseFare()*res2.getNoOfSeats());
		res3.setTotalFare(res3.getBus().getBaseFare()*res3.getNoOfSeats());
		res4.setTotalFare(res4.getBus().getBaseFare()*res4.getNoOfSeats());
		res5.setTotalFare(res5.getBus().getBaseFare()*res5.getNoOfSeats());
		
		entityManager.getTransaction().commit();
	
		entityManager.getTransaction().begin();
		
		seat11.setBus(bus1);
		seat21.setBus(bus2);
		seat31.setBus(bus3);
		seat12.setBus(bus1);
		seat22.setBus(bus2);
		seat32.setBus(bus3);
		seat13.setBus(bus1);
		seat23.setBus(bus2);
		seat33.setBus(bus3);
		seat14.setBus(bus1);
		seat24.setBus(bus2);
		seat34.setBus(bus3);
		seat15.setBus(bus1);
		seat25.setBus(bus2);
		seat35.setBus(bus3);
		
		seat11.setReserve(res1);
		seat12.setReserve(res2);
		seat13.setReserve(res3);
		seat23.setReserve(res2);
		seat24.setReserve(res2);
		seat35.setReserve(res3);
		seat14.setReserve(res4);
		seat21.setReserve(res5);
		
		entityManager.persist(seat11);
		entityManager.persist(seat12);
		entityManager.persist(seat13);
		entityManager.persist(seat14);
		entityManager.persist(seat15);
		entityManager.persist(seat21);
		entityManager.persist(seat22);
		entityManager.persist(seat23);
		entityManager.persist(seat24);
		entityManager.persist(seat25);
		entityManager.persist(seat31);
		entityManager.persist(seat32);
		entityManager.persist(seat33);
		entityManager.persist(seat34);
		entityManager.persist(seat35);
		
		pay1.setRes(res1);
		pay2.setRes(res2);
		pay3.setRes(res3);
		pay4.setRes(res4);
		pay5.setRes(res5);
		
		pay1.setDayDifference(pay1.getRes().getBus().getDeparture().getDate()- pay1.getRes().getBookingDate().getDate());
		pay2.setDayDifference(pay2.getRes().getBus().getDeparture().getDate()- pay2.getRes().getBookingDate().getDate());
		pay3.setDayDifference(pay3.getRes().getBus().getDeparture().getDate()- pay3.getRes().getBookingDate().getDate());
		pay4.setDayDifference(pay4.getRes().getBus().getDeparture().getDate()- pay4.getRes().getBookingDate().getDate());
		pay5.setDayDifference(pay5.getRes().getBus().getDeparture().getDate()- pay5.getRes().getBookingDate().getDate());
		
		pay1.setChargedFare(pay1.getAddedFare()/(pay1.getDayDifference()+1));
		pay2.setChargedFare(pay2.getAddedFare()/(pay2.getDayDifference()+1));
		pay3.setChargedFare(pay3.getAddedFare()/(pay3.getDayDifference()+1));
		pay4.setChargedFare(pay4.getAddedFare()/(pay4.getDayDifference()+1));
		pay5.setChargedFare(pay5.getAddedFare()/(pay5.getDayDifference()+1));
		
		entityManager.persist(pay1);
		entityManager.persist(pay2);
		entityManager.persist(pay3);
		entityManager.persist(pay4);
		entityManager.persist(pay5);
		
		entityManager.getTransaction().commit();
		
	}

}
