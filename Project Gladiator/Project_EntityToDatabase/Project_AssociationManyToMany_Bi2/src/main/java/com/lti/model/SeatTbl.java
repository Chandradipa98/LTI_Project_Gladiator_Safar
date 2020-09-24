package com.lti.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEAT_TBL")
public class SeatTbl {

	@Id
	@Column(name = "SERIAL_NO")
	private int serialNo;
	@Column(name = "BUS_ID")
	private int busId;
	@Column(name = "DEPARTURE")
	private LocalDateTime departure;
	@Column(name = "SEAT_ID")
	private int seatID;
	@Column(name = "TICKET_NO")
	private int ticketNo;

	public SeatTbl() {
		super();
	}

	public SeatTbl(int busId, LocalDateTime departure, int seatID, int ticketNo) {
		super();
		this.busId = busId;
		this.departure = departure;
		this.seatID = seatID;
		this.ticketNo = ticketNo;
	}

	public SeatTbl(int busId, LocalDateTime departure, int seatID) {
		super();
		this.busId = busId;
		this.departure = departure;
		this.seatID = seatID;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "SeatTbl [serialNo=" + serialNo + ", busId=" + busId + ", departure=" + departure + ", seatID=" + seatID
				+ ", ticketNo=" + ticketNo + "]";
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

}
