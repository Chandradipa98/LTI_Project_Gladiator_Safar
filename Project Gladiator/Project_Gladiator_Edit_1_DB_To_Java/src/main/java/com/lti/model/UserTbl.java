package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserTbl implements Serializable {
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DOB")
	private Date date;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "NO_OF_BOOKINGS")
	private int noOfBookings;

	@Column(name = "WALLET")
	private float wallet;

	// inverse side

	public void addTicket(ReservationTbl resv) {
		res.add(resv);
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ReservationTbl> res;

	public UserTbl() {
		super();
	}

	public UserTbl(String emailId, String firstName, String lastName, String phoneNo, String password, Date date,
			String gender, int noOfBookings, float wallet) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.password = password;
		this.date = date;
		this.gender = gender;
		this.noOfBookings = noOfBookings;
		this.wallet = wallet;
	}

	public UserTbl(String emailId, String firstName, String lastName, String phoneNo, String password, Date date,
			String gender) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.password = password;
		this.date = date;
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoOfBookings() {
		return noOfBookings;
	}

	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "UserTbl [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + ", password=" + password + ", date=" + date + ", gender=" + gender + ", noOfBookings="
				+ noOfBookings + ", wallet=" + wallet + "]";
	}

	public Set<ReservationTbl> getRes() {
		return res;
	}

	public void setRes(Set<ReservationTbl> res) {
		this.res = res;
	}

}
