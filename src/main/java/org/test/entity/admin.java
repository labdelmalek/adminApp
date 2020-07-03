package org.test.entity;

import java.util.Date;



public class admin {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String email;
 
	private String password;

	private String cin;
	

	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String adresse;
	

	private String phone;

	private String dateNaissance;
	
	private Date joiningDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "admin [email=" + email + ", password=" + password + ", cin=" + cin + ", id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", adresse=" + adresse + ", phone=" + phone
				+ ", dateNaissance=" + dateNaissance + ", joiningDate=" + joiningDate + "]";
	}
	
}
