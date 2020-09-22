package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
@SequenceGenerator(name = "seq", sequenceName = "ticket_seq", initialValue = 1, allocationSize = 1)
public class ReservationTbl implements Serializable {
	@Id
	@Column(name = "TICKET_NO")
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	private int ticketNo;

	@Column(name = "BOOKING_DATE")
	private Date bookingDate;

	@Column(name = "NO_OF_SEATS")
	private int noOfSeats;

	@Column(name = "TICKET_STATUS")
	private char ticketStatus;

	@Column(name = "CANCELLATION_DATE")
	private Date cancellationDate;

	@Column(name = "REFUND_AMOUNT")
	private double refundAmount;

	@Column(name = "TOTAL_FARE")
	private double totalFare;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	// inverse side

	// owner side
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "BUS_ID", referencedColumnName = "BUS_ID"),
			@JoinColumn(name = "DATE_OF_JOURNEY", referencedColumnName = "DEPARTURE") })
	private BusTbl bus;

	// inverse side
	@OneToMany(mappedBy = "reserve", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<SeatTbl> seats;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "REGISTERED", insertable = false, updatable = false)
	private UserTbl user;

	@OneToOne(mappedBy = "res", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Payment payment;

	public void addSeat(SeatTbl seat) {
		seats.add(seat);
	}

	public ReservationTbl() {
		super();
	}

	public ReservationTbl(Date bookingDate, int noOfSeats, char ticketStatus, BusTbl bus, double totalFare,
			String emailId, String phoneNo) {
		super();
		this.bookingDate = bookingDate;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.bus = bus;
		this.totalFare = totalFare;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public ReservationTbl(Date bookingDate, int noOfSeats, char ticketStatus, Date cancellationDate,
			double refundAmount, BusTbl bus, double totalFare, String emailId, String phoneNo) {
		super();
		this.bookingDate = bookingDate;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.cancellationDate = cancellationDate;
		this.refundAmount = refundAmount;
		this.bus = bus;
		this.totalFare = totalFare;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public ReservationTbl(Date bookingDate, int noOfSeats, char ticketStatus) {
		super();
		this.bookingDate = bookingDate;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public char getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(char ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BusTbl getBus() {
		return bus;
	}

	public void setBus(BusTbl bus) {
		this.bus = bus;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "ReservationTbl [ticketNo=" + ticketNo + ", bookingDate=" + bookingDate + ", noOfSeats=" + noOfSeats
				+ ", ticketStatus=" + ticketStatus + ", cancellationDate=" + cancellationDate + ", refundAmount="
				+ refundAmount + ", totalFare=" + totalFare + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", bus="
				+ bus + ", seats=" + seats + ", user=" + user + ", payment=" + payment + "]";
	}

	public Set<SeatTbl> getSeats() {
		return seats;
	}

	public void setSeats(Set<SeatTbl> seats) {
		this.seats = seats;
	}

	public UserTbl getUser() {
		return user;
	}

	public void setUser(UserTbl user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
