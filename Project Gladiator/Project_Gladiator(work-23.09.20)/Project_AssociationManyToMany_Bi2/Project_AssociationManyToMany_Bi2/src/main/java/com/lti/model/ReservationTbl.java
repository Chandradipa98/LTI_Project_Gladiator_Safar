package com.lti.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class ReservationTbl {

	@Id
	@Column(name = "TICKET_NO")
	private int ticektNo;
	@Column(name = "BOOKING_DATE")
	private Date bookingDate;
	@Column(name = "DATE_OF_JOURNEY")
	private LocalDateTime dateOfJourney;
	@Column(name = "NO_OF_SEATS")
	private int noOfSeats;
	@Column(name = "TICKET_STATUS")
	private char ticketStatus;
	@Column(name = "CANCELLATION_DATE")
	private Date cancellationDate;
	@Column(name = "REFUND_AMOUNT")
	private float refundAmount;
	@Column(name = "BUS_ID")
	private int busId;
	@Column(name = "TOTAL_FARE")
	private float totalFare;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PHONE_NO")
	private long phoneNo;

	public ReservationTbl() {
		super();
	}

	public ReservationTbl(int ticektNo, Date bookingDate, LocalDateTime dateOfJourney, int noOfSeats, char ticketStatus,
			Date cancellationDate, float refundAmount, int busId, float totalFare, String emailId, long phoneNo) {
		super();
		this.ticektNo = ticektNo;
		this.bookingDate = bookingDate;
		this.dateOfJourney = dateOfJourney;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.cancellationDate = cancellationDate;
		this.refundAmount = refundAmount;
		this.busId = busId;
		this.totalFare = totalFare;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public ReservationTbl(int ticektNo, Date bookingDate, LocalDateTime dateOfJourney, int noOfSeats, char ticketStatus,
			int busId, float totalFare, String emailId, long phoneNo) {
		super();
		this.ticektNo = ticektNo;
		this.bookingDate = bookingDate;
		this.dateOfJourney = dateOfJourney;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.busId = busId;
		this.totalFare = totalFare;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public int getTicektNo() {
		return ticektNo;
	}

	public void setTicektNo(int ticektNo) {
		this.ticektNo = ticektNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDateTime dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
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

	public float getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(float refundAmount) {
		this.refundAmount = refundAmount;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public float getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "ReservationTbl [ticektNo=" + ticektNo + ", bookingDate=" + bookingDate + ", dateOfJourney="
				+ dateOfJourney + ", noOfSeats=" + noOfSeats + ", ticketStatus=" + ticketStatus + ", cancellationDate="
				+ cancellationDate + ", refundAmount=" + refundAmount + ", busId=" + busId + ", totalFare=" + totalFare
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
	}

}
