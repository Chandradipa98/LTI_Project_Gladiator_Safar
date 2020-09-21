package com.lti.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_TBL")
@IdClass(PK_Bus.class)
public class BusTbl implements Serializable {

	@Id
	@Column(name = "BUS_ID")
	private int busId;
	@Id
	@Column(name = "DEPARTURE")
	private LocalDateTime departure;
	@Column(name = "ARRIVAL")
	private LocalDateTime arrival;
	@Column(name = "SOURCE")
	private String source;
	@Column(name = "DESTINATION")
	private String destination;
	@Column(name = "BASE_FARE")
	private float baseFare;
	@Column(name = "AVAILABLE_SEAT")
	private int availableSeat;
	@Column(name = "TOTAL_SEAT")
	private int totalSeat;
	@Column(name = "BUS_STATUS")
	private char busStatus;
	@Column(name = "COACH_BUS_STATUS")
	private char coachBusStatus;
	@Column(name = "DRIVER_STATUS")
	private char driverStatus;

	public BusTbl() {
		super();
	}

	public BusTbl(int busId, LocalDateTime departure, LocalDateTime arrival, String source, String destination,
			float baseFare, int availableSeat, int totalSeat, char busStatus, char coachBusStatus, char driverStatus) {
		super();
		this.busId = busId;
		this.departure = departure;
		this.arrival = arrival;
		this.source = source;
		this.destination = destination;
		this.baseFare = baseFare;
		this.availableSeat = availableSeat;
		this.totalSeat = totalSeat;
		this.busStatus = busStatus;
		this.coachBusStatus = coachBusStatus;
		this.driverStatus = driverStatus;
	}

	public BusTbl(int busId, LocalDateTime departure, LocalDateTime arrival, String source, String destination,
			float baseFare, int availableSeat, int totalSeat, char busStatus) {
		super();
		this.busId = busId;
		this.departure = departure;
		this.arrival = arrival;
		this.source = source;
		this.destination = destination;
		this.baseFare = baseFare;
		this.availableSeat = availableSeat;
		this.totalSeat = totalSeat;
		this.busStatus = busStatus;
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

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(float baseFare) {
		this.baseFare = baseFare;
	}

	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public char getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(char busStatus) {
		this.busStatus = busStatus;
	}

	public char getCoachBusStatus() {
		return coachBusStatus;
	}

	public void setCoachBusStatus(char coachBusStatus) {
		this.coachBusStatus = coachBusStatus;
	}

	public char getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(char driverStatus) {
		this.driverStatus = driverStatus;
	}

	@Override
	public String toString() {
		return "BusTbl [busId=" + busId + ", departure=" + departure + ", arrival=" + arrival + ", source=" + source
				+ ", destination=" + destination + ", baseFare=" + baseFare + ", availableSeat=" + availableSeat
				+ ", totalSeat=" + totalSeat + ", busStatus=" + busStatus + ", coachBusStatus=" + coachBusStatus
				+ ", driverStatus=" + driverStatus + "]";
	}

}
