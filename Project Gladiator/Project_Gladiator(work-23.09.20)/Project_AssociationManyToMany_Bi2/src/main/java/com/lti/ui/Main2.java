package com.lti.ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.BusTbl;
import com.lti.model.Payment;
import com.lti.model.ReservationTbl;
import com.lti.model.UserTbl;

public class Main2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();

		System.out.println("Welcome to Safar");

		System.out.println("1. Login?");
		System.out.println("2. Forgot Password?");
		System.out.println("3. Register?");
		System.out.println("4. Search Bus?");
		/*
		 * System.out.println("5. Select seat"); System.out.println("6. Book ticket?");
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		switch (n) {
		case 1:
			System.out.println("Enter 1 for Admin and 2 for User");
			int x = sc.nextInt();
			if (x == 1) {
				System.out.println("Enter Email: ");
				String em = sc.next();
				System.out.println("Enter Password: ");
				String ps = sc.next();
				if (em.equals("admin@gmail.com") && ps.equals("admin")) {
					boolean end = true;
					while (end) {
						String jpql = "select b from BusTbl b";
						TypedQuery<BusTbl> typedQuery = entityManager.createQuery(jpql, BusTbl.class);
						List<BusTbl> list = typedQuery.getResultList();
						for(BusTbl bus : list) {
							System.out.println(bus);
						}
						System.out.println("1. Add Bus?\n2. Update Bus?\n3. Remove Bus?\n0. Log Out");
						int a = sc.nextInt();
						switch (a) {
						case 1:
							System.out.println("Source: ");
							String s1 = sc.next();
							System.out.println("Destination: ");
							String s2 = sc.next();
							System.out.println("Base Fare: ");
							double fare = sc.nextDouble();
							System.out.println("Available Seat: ");
							int st1 = sc.nextInt();
							System.out.println("Total Seat: ");
							int st2 = sc.nextInt();
							System.out.println("Start time: ");
							String s3 = sc.next();
							System.out.println("Reach time: ");
							String s4 = sc.next();
							BusTbl bus = new BusTbl(new Date(), new Date(), s1, s2, fare, st1, st2, 'Y', s3, s4);
							entityManager.getTransaction().begin();
							entityManager.persist(bus);
							entityManager.getTransaction().commit();
							break;
						case 2:
							System.out.println("Enter bus id to update: ");
							int b = sc.nextInt();
							System.out.println("Source: ");
							String s5 = sc.next();
							System.out.println("Destination: ");
							String s6 = sc.next();
							System.out.println("Base Fare: ");
							double fare1 = sc.nextDouble();
							System.out.println("Start time: ");
							String s7 = sc.next();
							System.out.println("Reach time: ");
							String s8 = sc.next();

							String sqlQuery = "UPDATE BusTbl b SET b.source = :sc , b.destination = :dst, b.baseFare = :bf, b.startTime = :st, b.reachTime = :rt WHERE b.busId = :id";
							Query query = entityManager.createQuery(sqlQuery);
							query.setParameter("sc", s5);
							query.setParameter("dst", s6);
							query.setParameter("bf", fare1);
							query.setParameter("st", s7);
							query.setParameter("rt", s8);
							query.setParameter("id", b);
							entityManager.getTransaction().begin();
							int result = query.executeUpdate();
							entityManager.getTransaction().commit();
							System.out.println(result + "rows updated");
							break;
						case 3:
							System.out.println("Enter bus id to remove: ");
							int b1 = sc.nextInt();
							String jpql1 = "Delete From BusTbl b where b.busId = :id";
							Query query1 = entityManager.createQuery(jpql1);
							query1.setParameter("id", b1);
							entityManager.getTransaction().begin();
							int result1 = query1.executeUpdate();
							entityManager.getTransaction().commit();
							System.out.println(result1 + "rows updated");
							break;
						case 0:
							end = false;
							System.out.println("Logged Out");
							break;
						default:
							break;
						}
					}
				}else {
					System.out.println("Enter a valid EmailID or Password");
				}
			} else if (x == 2) {
				System.out.println("Enter Email: ");
				String em1 = sc.next();
				System.out.println("Enter Password: ");
				String ps1 = sc.next();
				
				String jpql = "Select u from UserTbl u";
				TypedQuery<UserTbl> typedQuery = entityManager.createQuery(jpql, UserTbl.class);
				List<UserTbl> list = typedQuery.getResultList();
				boolean flag = true;
				for(UserTbl user : list) {
					if(em1.equals(user.getEmailId())) {
						flag = true;
						if(ps1.equals(user.getPassword())) {
							System.out.println("Logged in");
							break;
						}else {
							System.out.println("Password Wrong");
							flag = false;
							break;
						}
					}
					flag = false;
				}
				if(flag==true) {
					String sql = "Select u from UserTbl u where u.emailId = :em";
					TypedQuery<UserTbl> tQuery = entityManager.createQuery(sql, UserTbl.class);
					tQuery.setParameter("em", em1);
					UserTbl utb = tQuery.getSingleResult();
					
					System.out.println("Search Bus");
					System.out.println("Source: ");
					String s1 = sc.next();
					System.out.println("Destination: ");
					String s2 = sc.next();
					String jpql1 = "select b from BusTbl b where b.source = :sc AND b.destination = :dst";
					TypedQuery<BusTbl> typedQuery1 = entityManager.createQuery(jpql1, BusTbl.class);
					typedQuery1.setParameter("sc", s1);
					typedQuery1.setParameter("dst", s2);
					List<BusTbl> list1 = typedQuery1.getResultList();
					for(BusTbl bus : list1) {
						System.out.println(bus);
					}
					System.out.println("Enter the Bus ID: ");
					int id = sc.nextInt();
					
					String sqlQuery = "Select b from BusTbl b where b.busId = :id";
					TypedQuery<BusTbl> tQuery1 = entityManager.createQuery(sqlQuery, BusTbl.class);
					tQuery1.setParameter("id", id);
					BusTbl bus = tQuery1.getSingleResult();
					
					System.out.println("Enter no of seats: ");
					int j = sc.nextInt();
					
					System.out.println("Enter Mode of Payment: ");
					String mode = sc.next();
					
					System.out.println("Enter yes to Book: ");
					String yes = sc.next();
					
					if(yes.equalsIgnoreCase("yes")) {
						
						Payment pay = new Payment(1000, mode);
						
						ReservationTbl res = new ReservationTbl(new Date(), j, 'Y', em1);
						
						entityManager.getTransaction().begin();
						entityManager.persist(res);
						res.setUser(utb);
						res.setPhoneNo(res.getUser().getPhoneNo());
						res.setBus(bus);
						entityManager.getTransaction().commit();
						
						entityManager.getTransaction().begin();
						
						entityManager.persist(pay);
						pay.setRes(res);
						res.setPayment(pay);
						pay.setDayDifference(pay.getRes().getBus().getDeparture().getDate()- pay.getRes().getBookingDate().getDate());
						pay.setChargedFare(pay.getAddedFare()-(pay.getDayDifference())*10);
						res.setTotalFare(res.getBus().getBaseFare()*res.getNoOfSeats()+res.getPayment().getChargedFare());
						
						entityManager.getTransaction().commit();
						
						String jpql2 = "Update BusTbl b SET b.availableSeat = :st where b.busId = :id";
						Query query = entityManager.createQuery(jpql2);
						query.setParameter("st", 20-j);
						query.setParameter("id", id);
						
						entityManager.getTransaction().begin();
						
						int result = query.executeUpdate();
						entityManager.getTransaction().commit();
						
						System.out.println("Your ticket details:");
						String sql2 = "select r from ReservationTbl r where r.emailId = :em1";
						TypedQuery<ReservationTbl> tQuery2 = entityManager.createQuery(sql2, ReservationTbl.class);
						tQuery2.setParameter("em1", em1);
						List<ReservationTbl> list2 = tQuery2.getResultList();
						for(ReservationTbl rt : list2) {
							System.out.println(rt);
						}
					}
					
				}
			}
			break;

		default:
			break;
		}
	}
}
