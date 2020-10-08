package com.lti.model;

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
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Scope(scopeName="prototype")
@Entity
@Table(name = "SEAT_TBL")
public class SeatTbl {
	@Id
	@Column(name = "SERIAL_NO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serialNo;
	
	@Column(name = "SEAT_ID")
	private int seatId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TICKET_NO")
	private ReservationTbl reserve;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
        @JoinColumn(
            name = "BUS_ID",
            referencedColumnName = "BUS_ID"),
        @JoinColumn(
            name = "DEPARTURE",
            referencedColumnName = "DEPARTURE")
    })
	private BusTbl busDetails;
	
	public SeatTbl() {
		super();
	}
	
	public SeatTbl( int seatId) {
		super();
		this.seatId = seatId;
	}

		public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public ReservationTbl getReserve() {
		return reserve;
	}

	public void setReserve(ReservationTbl reserve) {
		this.reserve = reserve;
	}

	@Override
	public String toString() {
		return "SeatTbl [serialNo=" + serialNo + ", seatId=" + seatId + ", reserve=" + reserve + ", busDetails="
				+ getBusDetails() + "]";
	}

	public BusTbl getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusTbl busDetails) {
		this.busDetails = busDetails;
	}
}
