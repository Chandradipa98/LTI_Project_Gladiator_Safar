package com.lti.ui;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.email.SendMail;
import com.lti.model.BusTbl;
import com.lti.model.Payment;
import com.lti.model.ReservationTbl;
import com.lti.model.SeatTbl;
import com.lti.model.UserTbl;

public class Main2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		while (exit) {
			System.out.println("Welcome to Safar");

			System.out.println("1. Login?");
			System.out.println("2. Register?");
			System.out.println("3. Search Bus?");
			System.out.println("4. Forgot Password?");
			System.out.println("5. Hire Bus?");
			System.out.println("6. Exit?");
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
							for (BusTbl bus : list) {
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
								System.out.println("Coach Bus Status: ");
								String s0 = sc.next();
								char c = s0.charAt(0);
								BusTbl bus = new BusTbl(new Date(), new Date(), s1, s2, fare, st1, st2, 'Y', s3, s4);
								entityManager.getTransaction().begin();
								entityManager.persist(bus);
								bus.setCoachBusStatus(c);
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
					} else {
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
					for (UserTbl user : list) {
						if (em1.equals(user.getEmailId())) {
							flag = true;
							if (ps1.equals(user.getPassword())) {
								System.out.println("Logged in");
								break;
							} else {
								System.out.println("Password Wrong");
								flag = false;
								break;
							}
						}
						flag = false;
					}
					if (flag == true) {
						String sql = "Select u from UserTbl u where u.emailId = :em";
						TypedQuery<UserTbl> tQuery = entityManager.createQuery(sql, UserTbl.class);
						tQuery.setParameter("em", em1);
						UserTbl utb = tQuery.getSingleResult();

						System.out.println("Search Bus");
						System.out.println("Source: ");
						String s1 = sc.next();
						System.out.println("Destination: ");
						String s2 = sc.next();
						char cs = 'N';
						String jpql1 = "select b from BusTbl b where b.source = :sc AND b.destination = :dst AND b.coachBusStatus = :c";
						TypedQuery<BusTbl> typedQuery1 = entityManager.createQuery(jpql1, BusTbl.class);
						typedQuery1.setParameter("sc", s1);
						typedQuery1.setParameter("dst", s2);
						typedQuery1.setParameter("c", cs);
						List<BusTbl> list1 = typedQuery1.getResultList();
						for (BusTbl bus : list1) {
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
					
						Set<Integer> seat = new HashSet<Integer>();
						System.out.println("Enter Seat IDs: ");
						int seatId = 0;
						for(int k = 1; k<=j; k++) {
							seatId = sc.nextInt();
							seat.add(seatId);
						}
						
						System.out.println("Enter Mode of Payment: ");
						String mode = sc.next();

						System.out.println("Enter yes to Book: ");
						String yes = sc.next();

						if (yes.equalsIgnoreCase("yes")) {

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
							pay.setDayDifference(pay.getRes().getBus().getDeparture().getDate()
									- pay.getRes().getBookingDate().getDate());
							pay.setChargedFare(pay.getAddedFare() - (pay.getDayDifference()) * 10);
							res.setTotalFare(res.getBus().getBaseFare() * res.getNoOfSeats()
									+ res.getPayment().getChargedFare());

							entityManager.getTransaction().commit();

							String jpql2 = "Update BusTbl b SET b.availableSeat = :st where b.busId = :id";
							Query query = entityManager.createQuery(jpql2);
							query.setParameter("st", bus.getAvailableSeat() - j);
							query.setParameter("id", id);

							entityManager.getTransaction().begin();
							int result = query.executeUpdate();
							entityManager.getTransaction().commit();

							for(int stid : seat) {
								SeatTbl st = new SeatTbl(stid);
								st.setReserve(res);
								st.setBus(res.getBus());
								entityManager.getTransaction().begin();
								entityManager.persist(st);
								entityManager.getTransaction().commit();
							}
							
							System.out.println("Your ticket details:");
							String sql2 = "select r from ReservationTbl r where r.emailId = :em1";
							TypedQuery<ReservationTbl> tQuery2 = entityManager.createQuery(sql2, ReservationTbl.class);
							tQuery2.setParameter("em1", em1);
							List<ReservationTbl> list2 = tQuery2.getResultList();
							for (ReservationTbl rt : list2) {
								System.out.println(rt);
							}
							
							SendMail sm = new SendMail();
							sm.mssg="Reservation Succesful";
							sm.send=em1;
							sm.subject="Reservation Details: "+"\nTicket no: "+res.getTicketNo()+"\nTotal Fare: "+res.getTotalFare()+"\nBooking Date: "+res.getBookingDate()+"\nBus Details: "+res.getBus()+"\nNo Of Seats: "+res.getNoOfSeats()+"\nPayment Id: "+res.getPayment().getPaymentId()
									+"\nPayment Method: "+res.getPayment().getPaymentMethod()+"\nCharged Fare: "+res.getPayment().getChargedFare();
							sm.sendEmail();
						}

					}
				}
				break;
			case 2:
				System.out.println("Enter Your email Id: ");
				String e = sc.next();
				System.out.println("Enter Your First Name: ");
				String fn = sc.next();
				System.out.println("Enter Your Last Name: ");
				String ln = sc.next();
				System.out.println("Enter Your Phone No: ");
				String pn = sc.next();
				System.out.println("Enter Your Password: ");
				String ps1 = sc.next();
				System.out.println("Confirm Your Password: ");
				String ps2 = sc.next();
				System.out.println("Enter Your Gender: ");
				String gn = sc.next();
				if (ps1.equals(ps2)) {
					UserTbl utb1 = new UserTbl(e, fn, ln, pn, ps1, new Date(), gn);
					entityManager.getTransaction().begin();
					entityManager.persist(utb1);
					entityManager.getTransaction().commit();
					System.out.println("Registration Successful!");
				} else {
					System.out.println("Password fields don't match");
				}

				break;
			case 3:
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
				for (BusTbl bus : list1) {
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
				
				System.out.println("Enter your email address: ");
				String em = sc.next();
				
				System.out.println("Enter your Phone no: ");
				String pno = sc.next();
				
				if (yes.equalsIgnoreCase("yes")) {
					Payment pay = new Payment(1000, mode);

					ReservationTbl res = new ReservationTbl(new Date(), j, 'Y');

					entityManager.getTransaction().begin();
					entityManager.persist(res);
					res.setEmailId(em);
					res.setPhoneNo(pno);
					res.setBus(bus);
					entityManager.getTransaction().commit();
					
					entityManager.getTransaction().begin();
					entityManager.persist(pay);
					pay.setRes(res);
					res.setPayment(pay);
					pay.setDayDifference(pay.getRes().getBus().getDeparture().getDate()
							- pay.getRes().getBookingDate().getDate());
					pay.setChargedFare(pay.getAddedFare() - (pay.getDayDifference()) * 10);
					res.setTotalFare(res.getBus().getBaseFare() * res.getNoOfSeats()
							+ res.getPayment().getChargedFare());

					entityManager.getTransaction().commit();

					String jpql2 = "Update BusTbl b SET b.availableSeat = :st where b.busId = :id";
					Query query = entityManager.createQuery(jpql2);
					query.setParameter("st", bus.getAvailableSeat() - j);
					query.setParameter("id", id);

					entityManager.getTransaction().begin();
					int result = query.executeUpdate();
					entityManager.getTransaction().commit();

					System.out.println("Your ticket details:");
					String sql2 = "select r from ReservationTbl r where r.emailId = :em";
					TypedQuery<ReservationTbl> tQuery2 = entityManager.createQuery(sql2, ReservationTbl.class);
					tQuery2.setParameter("em", em);
					List<ReservationTbl> list2 = tQuery2.getResultList();
					for (ReservationTbl rt : list2) {
						System.out.println(rt);
					}
					SendMail sm = new SendMail();
					sm.mssg="Reservation Succesful";
					sm.send=em;
					sm.subject="Reservation Details: "+"\nTicket no: "+res.getTicketNo()+"\nTotal Fare: "+res.getTotalFare()+"\nBooking Date: "+res.getBookingDate()+"\nBus Details: "+res.getBus()+"\nNo Of Seats: "+res.getNoOfSeats()+"\nPayment Id: "+res.getPayment().getPaymentId()
							+"\nPayment Method: "+res.getPayment().getPaymentMethod()+"\nCharged Fare: "+res.getPayment().getChargedFare();
					sm.sendEmail();
				}
				break;
			case 4:
				System.out.println("Forgot Password?");
				System.out.println("Enter Your Email Address: ");
				String email = sc.next();
				SendMail sm = new SendMail();
				
				char[] ch = sm.createOtp();
				String s = ch.toString();
				sm.mssg = "Otp to reset password";
				sm.subject = "Your Otp is : "+s;
				sm.send = email;
				sm.sendEmail();
				
				System.out.println("Enter Your Otp: ");
				String s0 = sc.next();
				
				if(s0.equals(s)) {
					System.out.println("Enter your new password: ");
					String p1 = sc.next();
					System.out.println("Confirm Your Password: ");
					String p2 = sc.next();
					if (p1.equals(p2)) {
						String jpql = "Update UserTbl u Set u.password = :p where u.emailId = :em";
						Query query = entityManager.createQuery(jpql);
						query.setParameter("p", p1);
						query.setParameter("em", email);
						entityManager.getTransaction().begin();
						int result = query.executeUpdate();
						entityManager.getTransaction().commit();
						System.out.println("Password Reset Successful!");
					} else {
						System.out.println("Password fields don't match");
					}
				}else {
					System.out.println("Invalid Otp");
				}
				break;
			case 5:
				System.out.println("Enter Email: ");
				String eml = sc.next();
				System.out.println("Enter Password: ");
				String pass = sc.next();

				String jpql = "Select u from UserTbl u";
				TypedQuery<UserTbl> typedQuery = entityManager.createQuery(jpql, UserTbl.class);
				List<UserTbl> list = typedQuery.getResultList();
				boolean flag = true;
				for (UserTbl user : list) {
					if (eml.equals(user.getEmailId())) {
						flag = true;
						if (pass.equals(user.getPassword())) {
							System.out.println("Logged in");
							break;
						} else {
							System.out.println("Password Wrong");
							flag = false;
							break;
						}
					}
					flag = false;
				}
				if(flag == true) {
					String sql3 = "Select u from UserTbl u where u.emailId = :em";
					TypedQuery<UserTbl> tQuery = entityManager.createQuery(sql3, UserTbl.class);
					tQuery.setParameter("em", eml);
					UserTbl utb3 = tQuery.getSingleResult();
					
					System.out.println("Search Bus");
					System.out.println("Source: ");
					String st = sc.next();
					System.out.println("Destination: ");
					String st1 = sc.next();
					char c1 = 'Y';
					String jpql3 = "select b from BusTbl b where b.source = :sc AND b.destination = :dst AND b.coachBusStatus = :c";
					TypedQuery<BusTbl> typedQuery3 = entityManager.createQuery(jpql3, BusTbl.class);
					typedQuery3.setParameter("sc", st);
					typedQuery3.setParameter("dst", st1);
					typedQuery3.setParameter("c", c1);
					List<BusTbl> list3 = typedQuery3.getResultList();
					for (BusTbl cbus : list3) {
						System.out.println(cbus);
					}
					System.out.println("Enter the Bus ID: ");
					int i = sc.nextInt();

					String sQuery = "Select b from BusTbl b where b.busId = :id";
					TypedQuery<BusTbl> tQuery3 = entityManager.createQuery(sQuery, BusTbl.class);
					tQuery3.setParameter("id", i);
					BusTbl cbus = tQuery3.getSingleResult();

					System.out.println("Enter Mode of Payment: ");
					String mode1 = sc.next();

					System.out.println("Enter Y/N to Book a Driver: ");
					String y = sc.next();
					char ch1 = y.charAt(0);
					
					System.out.println("Enter yes to Book: ");
					String yes1 = sc.next();

					if (yes1.equalsIgnoreCase("yes")) {

						Payment pay = new Payment(1000, mode1);

						ReservationTbl res = new ReservationTbl(new Date(), 20, 'Y', eml);

						entityManager.getTransaction().begin();
						entityManager.persist(res);
						res.setUser(utb3);
						res.setPhoneNo(res.getUser().getPhoneNo());
						res.setBus(cbus);
						res.setDriverStatus(ch1);
						entityManager.getTransaction().commit();

						entityManager.getTransaction().begin();
						entityManager.persist(pay);
						pay.setRes(res);
						res.setPayment(pay);
						pay.setDayDifference(pay.getRes().getBus().getDeparture().getDate()
								- pay.getRes().getBookingDate().getDate());
						pay.setChargedFare(pay.getAddedFare() - (pay.getDayDifference()) * 10);
						res.setTotalFare(res.getBus().getBaseFare() * res.getBus().getTotalSeat()
								+ res.getPayment().getChargedFare());
						if(res.getDriverStatus()=='N') {
							res.setTotalFare(res.getTotalFare()+300);
						}
						entityManager.getTransaction().commit();

						String jpql2 = "Update BusTbl b SET b.availableSeat = :st where b.busId = :id";
						Query query = entityManager.createQuery(jpql2);
						query.setParameter("st", 0);
						query.setParameter("id", i);

						entityManager.getTransaction().begin();
						int result = query.executeUpdate();
						entityManager.getTransaction().commit();

						System.out.println("Your ticket details:");
						String sql2 = "select r from ReservationTbl r where r.emailId = :em1";
						TypedQuery<ReservationTbl> tQuery2 = entityManager.createQuery(sql2, ReservationTbl.class);
						tQuery2.setParameter("em1", eml);
						List<ReservationTbl> list2 = tQuery2.getResultList();
						for (ReservationTbl rt : list2) {
							System.out.println(rt);
						}
						
						SendMail sm1 = new SendMail();
						sm1.mssg="Reservation Succesful";
						sm1.send=eml;
						sm1.subject="Reservation Details: "+"\nTicket no: "+res.getTicketNo()+"\nTotal Fare: "+res.getTotalFare()+"\nBooking Date: "+res.getBookingDate()+"\nCoach Bus Details: "+res.getBus()+"\nPayment Id: "+res.getPayment().getPaymentId()
								+"\nPayment Method: "+res.getPayment().getPaymentMethod()+"\nCharged Fare: "+res.getPayment().getChargedFare();
						sm1.sendEmail();
					}

				}
				break;
			case 6:
				exit = false;
				break;

			default:
				break;
			}
		}
	}
}
