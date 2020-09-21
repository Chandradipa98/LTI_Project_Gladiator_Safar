package com.lti.model;

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
@Table(name = "USER_TBL")
public class UserTbl {

	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "PHONE_NO")
	private String phoneNo;
	@Column(name = "DOB")
	private Date dateOfBirth;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "NO_OF_BOOKINGS")
	private int noOfBookings;
	@Column(name = "WALLET")
	private float wallet;

	@OneToMany(mappedBy = "userTbl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RegisteredUserTicket> registerTicket;

	public UserTbl() {
		super();
	}

	public UserTbl(String emailId, String password, String firstName, String lastName, String phoneNo, Date dateOfBirth,
			String gender, int noOfBookings, float wallet) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.noOfBookings = noOfBookings;
		this.wallet = wallet;
	}

	public UserTbl(String emailId, String password, String firstName, String lastName, String phoneNo, Date dateOfBirth,
			String gender) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public void addTicket(RegisteredUserTicket reg)
	{
		registerTicket.add(reg);
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		return "UserTbl [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNo=" + phoneNo + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", noOfBookings=" + noOfBookings + ", wallet=" + wallet + "]";
	}

	public Set<RegisteredUserTicket> getRegisterTicket() {
		return registerTicket;
	}

	public void setRegisterTicket(Set<RegisteredUserTicket> registerTicket) {
		this.registerTicket = registerTicket;
	}

}
