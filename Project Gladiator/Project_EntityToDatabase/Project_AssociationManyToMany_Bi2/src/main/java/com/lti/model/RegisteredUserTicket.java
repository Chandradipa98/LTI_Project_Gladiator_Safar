package com.lti.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTERED_USER_TICKET")
public class RegisteredUserTicket {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name = "TICKET_NO")
	private int ticketNo;

	@ManyToOne
	@JoinColumn(name = "REGISTERED_DETAILS")
	private UserTbl userTbl;

	public RegisteredUserTicket() {
		super();
	}

	public RegisteredUserTicket(int userId, int ticketNo) {
		super();
		this.userId = userId;
		this.ticketNo = ticketNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "RegisteredUserTicket [userId=" + userId + ", ticketNo=" + ticketNo + "]";
	}

	public UserTbl getUserTbl() {
		return userTbl;
	}

	public void setUserTbl(UserTbl userTbl) {
		this.userTbl = userTbl;
	}

}
