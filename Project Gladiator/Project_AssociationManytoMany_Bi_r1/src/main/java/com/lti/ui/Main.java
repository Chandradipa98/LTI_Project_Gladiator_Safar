package com.lti.ui;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.BusTbl;
import com.lti.model.RegisteredUserTicket;
import com.lti.model.ReservationTbl;
import com.lti.model.SeatTbl;
import com.lti.model.UserTbl;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		UserTbl utb1 = new UserTbl("s@gmail.com", "Mani", "Nag", "9875522689", "mn29", new Date(), "female");
		UserTbl utb2 = new UserTbl("g@gmail.com", "Chandradipa", "Nag", "9775773152", "cn29", new Date(), "female");
		
		RegisteredUserTicket rgut1 = new RegisteredUserTicket();
		RegisteredUserTicket rgut2 = new RegisteredUserTicket();
		RegisteredUserTicket rgut3 = new RegisteredUserTicket();
		
		
		ReservationTbl res1 = new ReservationTbl(new Date(), 3, 'Y');
		ReservationTbl res2 = new ReservationTbl(new Date(), 2, 'Y');
		ReservationTbl res3 = new ReservationTbl(new Date(), 1, 'Y');
		
		ReservationTbl res4 = new ReservationTbl(new Date(), 1, 'Y');
		ReservationTbl res5 = new ReservationTbl(new Date(), 1, 'Y');
		
		BusTbl bus1 = new BusTbl(new Date(), new Date(), "Kolkata", "Pune", 350, 10, 20, 'Y', "10.30 a.m.", "10.30 p.m.");
		BusTbl bus2 = new BusTbl(new Date(), new Date(), "Kolkata", "Howrah", 100, 15, 20, 'Y', "11.00 a.m.", "12.00 p.m.");		
		BusTbl bus3 = new BusTbl(new Date(), new Date(), "Mumbai", "Delhi", 400, 12, 20, 'Y', "1.00 a.m.", "1.00 p.m.");
		
		SeatTbl seat11 = new SeatTbl(1);
		SeatTbl seat12 = new SeatTbl(2);
		SeatTbl seat13 = new SeatTbl(3);
		SeatTbl seat14 = new SeatTbl(4);
		SeatTbl seat15 = new SeatTbl(5);
		
		SeatTbl seat21 = new SeatTbl(1);
		SeatTbl seat22 = new SeatTbl(2);
		SeatTbl seat23 = new SeatTbl(3);
		SeatTbl seat24 = new SeatTbl(4);
		SeatTbl seat25 = new SeatTbl(5);
		
		SeatTbl seat31 = new SeatTbl(1);
		SeatTbl seat32 = new SeatTbl(2);
		SeatTbl seat33 = new SeatTbl(3);
		SeatTbl seat34 = new SeatTbl(4);
		SeatTbl seat35 = new SeatTbl(5);
		
		res4.setEmailId("xyz@gmail.com");
		res5.setEmailId("xz@gmail.com");
		res4.setPhoneNo("9048434243");
		res5.setPhoneNo("9045623498");
		
		rgut1.setTicketNo(res1);
		rgut2.setTicketNo(res2);
		rgut3.setTicketNo(res3);
		
		/*res1.setEmailId(rgut1.getUserTbl().getEmailId());
		res2.setEmailId(rgut2.getUserTbl().getEmailId());
		res3.setEmailId(rgut3.getUserTbl().getEmailId());
		
		res1.setPhoneNo(rgut1.getUserTbl().getPhoneNo());
		res2.setPhoneNo(rgut2.getUserTbl().getPhoneNo());
		res3.setPhoneNo(rgut3.getUserTbl().getPhoneNo());*/
		
		/*utb1.setRegisterTicket(new HashSet<RegisteredUserTicket>());
		utb1.addTicket(rgut1);
		utb1.addTicket(rgut2);
		
		utb2.setRegisterTicket(new HashSet<RegisteredUserTicket>());
		utb2.addTicket(rgut3);*/
		
		rgut1.setUserTbl(utb1);
		rgut2.setUserTbl(utb1);
		rgut3.setUserTbl(utb2);
		
		entityManager.getTransaction().begin();
		entityManager.persist(utb1);
		entityManager.persist(utb2);
		entityManager.persist(rgut1);
		entityManager.persist(rgut2);
		entityManager.persist(rgut3);
		entityManager.persist(res4);
		entityManager.persist(res5);
		
		
		res1.setEmailId(rgut1.getUserTbl().getEmailId());
		res2.setEmailId(rgut2.getUserTbl().getEmailId());
		res3.setEmailId(rgut3.getUserTbl().getEmailId());
		
		res1.setPhoneNo(rgut1.getUserTbl().getPhoneNo());
		res2.setPhoneNo(rgut2.getUserTbl().getPhoneNo());
		res3.setPhoneNo(rgut3.getUserTbl().getPhoneNo());
		
		res1.setBus(bus1);
		res2.setBus(bus2);
		res3.setBus(bus2);
		res4.setBus(bus3);
		res5.setBus(bus3);
		
		double fare1 = res1.getBus().getBaseFare()*res1.getNoOfSeats();
		double fare2 = res2.getBus().getBaseFare()*res2.getNoOfSeats();
		double fare3 = res3.getBus().getBaseFare()*res3.getNoOfSeats();
		double fare4 = res4.getBus().getBaseFare()*res4.getNoOfSeats();
		double fare5 = res5.getBus().getBaseFare()*res5.getNoOfSeats();
		
		res1.setTotalFare(fare1);
		res2.setTotalFare(fare2);
		res3.setTotalFare(fare3);
		res4.setTotalFare(fare4);
		res5.setTotalFare(fare5);
		
		Set<SeatTbl> seats1 = new HashSet<SeatTbl>();
		seats1.add(seat11);
		seats1.add(seat12);
		seats1.add(seat13);
		seats1.add(seat14);
		seats1.add(seat15);
		
		Set<SeatTbl> seats2 = new HashSet<SeatTbl>();
		seats2.add(seat21);
		seats2.add(seat22);
		seats2.add(seat23);
		seats2.add(seat24);
		seats2.add(seat25);
		
		Set<SeatTbl> seats3 = new HashSet<SeatTbl>();
		seats3.add(seat31);
		seats3.add(seat32);
		seats3.add(seat33);
		seats3.add(seat34);
		seats3.add(seat35);
		
		bus1.setSeat(seats1);
		bus2.setSeat(seats2);
		bus3.setSeat(seats3);
		
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
		
		entityManager.getTransaction().commit();
		
		System.out.println(rgut1.getUserTbl());
		System.out.println(rgut2.getUserTbl());
		System.out.println(rgut3.getUserTbl());
		
		//System.out.println(rgut1.getTicketNo());
		//System.out.println(utb1.getEmailId());
		//System.out.println(seat1);
		
	}

}
