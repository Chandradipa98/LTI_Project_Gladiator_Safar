package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTEREDUSERTICKET")
public class RegisteredUserTicket {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	//owner side
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TICKET_NO")
	private ReservationTbl ticketNo;
	
	//owner side
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REGISTERED_DETAILS")
	private UserTbl userTbl;
	
	public RegisteredUserTicket() {
		super();
	}
	public RegisteredUserTicket(int userId) {
		super();
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserTbl getUserTbl() {
		return userTbl;
	}
	public void setUserTbl(UserTbl userTbl) {
		this.userTbl = userTbl;
	}
	public ReservationTbl getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(ReservationTbl ticketNo) {
		this.ticketNo = ticketNo;
	}
	@Override
	public String toString() {
		return "RegisteredUserTicket [userId=" + userId + ", ticketNo=" + ticketNo + ", userTbl=" + userTbl + "]";
	}
}
