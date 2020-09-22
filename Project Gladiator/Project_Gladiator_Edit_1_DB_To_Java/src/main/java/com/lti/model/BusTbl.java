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
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_DETAILS")
//@SequenceGenerator(name = "seq3", sequenceName = "bus_seq", initialValue = 1, allocationSize = 1)
@IdClass(PK_Bus.class)
public class BusTbl implements Serializable{
	@Id
	@Column(name = "BUS_ID")
	@SequenceGenerator(name = "seq3", sequenceName = "bus_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq3", strategy = GenerationType.SEQUENCE)
	private int busId;
	
	@Id
	@Column(name = "DEPARTURE")
	private Date departure;
	
	@Column(name = "ARRIVAL")
	private Date arrival;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "BASE_FARE")
	private double baseFare;
	
	@Column(name = "AVAILABLE_SEAT")
	private int availableSeat;
	
	@Column(name = "TOTAL_SEAT")
	private int totalSeat;
	
	@Column(name = "BUS_STATUS")
	private char busStatus;
	
	@Column(name = "COACH_BUS_STATUS")
	private char coachBusStatus='N';
	
	@Column(name = "DRIVER_STATUS")
	private char driverStatus='N';
	
	@Column(name = "START_TIME")
	private String startTime;
	
	@Column(name = "REACH_TIME")
	private String reachTime;
	
	//inverse side
	@OneToMany(mappedBy = "bus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ReservationTbl> reservations;
	
	//inverse side
	@OneToMany(mappedBy = "busDetails", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<SeatTbl> seats;
	
	public BusTbl() {
		super();
	}
	public BusTbl(Date departure, Date arrival, String source, String destination, double baseFare,
			int availableSeat, int totalSeat, char busStatus, String startTime, String reachTime) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.source = source;
		this.destination = destination;
		this.baseFare = baseFare;
		this.availableSeat = availableSeat;
		this.totalSeat = totalSeat;
		this.busStatus = busStatus;
		this.startTime = startTime;
		this.reachTime = reachTime;
	}
	public BusTbl(Date departure, Date arrival, String source, String destination, double baseFare,
			int availableSeat, int totalSeat, char busStatus, char coachBusStatus, char driverStatus, String startTime,
			String reachTime) {
		super();
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
		this.startTime = startTime;
		this.reachTime = reachTime;
	}
	
	
	
	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
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

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getReachTime() {
		return reachTime;
	}

	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}
	public Set<ReservationTbl> getReservations() {
		return reservations;
	}
	public void setReservations(Set<ReservationTbl> reservations) {
		this.reservations = reservations;
	}
	public Set<SeatTbl> getSeats() {
		return seats;
	}
	public void setSeats(Set<SeatTbl> seats) {
		this.seats = seats;
	}
	
}
