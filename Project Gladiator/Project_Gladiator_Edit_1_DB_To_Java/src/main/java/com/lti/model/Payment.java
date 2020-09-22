package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
@SequenceGenerator(name = "seq2", sequenceName = "payment_seq", initialValue = 1, allocationSize = 1)
public class Payment implements Serializable {
	@Id
	@Column(name = "PAYMENT_ID")
	@GeneratedValue(generator = "seq2", strategy = GenerationType.SEQUENCE)
	private int paymentId;

	@Column(name = "ADDED_FARE")
	private double addedFare;

	// owner side
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TICKET_NO")
	private ReservationTbl res;

	@Column(name = "DAY_DIFFERENCE")
	private int dayDifference;

	@Column(name = "CHARGED_FARE")
	private double chargedFare;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;
	
	
	

	public Payment() {
		super();
	}

	public Payment(int paymentId, String paymentMode, double addedFare, ReservationTbl res, int dayDifference,
			double chargedFare) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.addedFare = addedFare;
		this.res = res;
		this.dayDifference = dayDifference;
		this.chargedFare = chargedFare;
	}

	public Payment(double addedFare, String paymentMode) {
		super();
		this.addedFare = addedFare;
		this.paymentMode = paymentMode;
	}

	public Payment(double addedFare) {
		super();
		this.addedFare = addedFare;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAddedFare() {
		return addedFare;
	}

	public void setAddedFare(double addedFare) {
		this.addedFare = addedFare;
	}

	public ReservationTbl getRes() {
		return res;
	}

	public void setRes(ReservationTbl res) {
		this.res = res;
	}

	public int getDayDifference() {
		return dayDifference;
	}

	public void setDayDifference(int dayDifference) {
		this.dayDifference = dayDifference;
	}

	public double getChargedFare() {
		return chargedFare;
	}

	public void setChargedFare(double chargedFare) {
		this.chargedFare = chargedFare;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", addedFare=" + addedFare + ", res=" + res + ", dayDifference="
				+ dayDifference + ", chargedFare=" + chargedFare + ", paymentMode=" + paymentMode + "]";
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}