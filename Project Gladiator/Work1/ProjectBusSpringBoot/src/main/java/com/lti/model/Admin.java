package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
@Entity
@Table(name = "ADMIN_DETAILS")
public class Admin {
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId = "admin@gmail.com";
	private String password = "admin";

	@Override
	public String toString() {
		return "Admin [emailId=" + emailId + ", password=" + password + "]";
	}
}
