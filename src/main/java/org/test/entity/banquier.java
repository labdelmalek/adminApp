package org.test.entity;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class banquier  {
private static final long serialVersionUID = 1L;
	



private Long id;


//@NotNull(message = "firstname cannot be null.") 
//@NotBlank(message = "firstname cannot be null.")
//@Size(min=3, max=30,message = "enter a valid firstName.")
private String firstName;


//@NotNull(message = "lastname cannot be null.") 
//@NotBlank(message = "lastname cannot be null.")
//@Size(min=3, max=30,message = "enter a valid lastName.")
private String lastName;


//@NotNull(message = "adress cannot be null.")
//@NotBlank(message = "adress cannot be null.")
//@Size(min=8, max=160,message = "enter a valid adress.")
private String adresse;

//@Column(name="cin",unique=true)
//@NotNull(message = "CIN cannot be null.") 
//@NotBlank()
//@Size(min=7, max=15,message = "enter a valid CIN.")
//@Pattern(regexp="^[a-zA-Z]{1,2}[0-9].*[0-9]$", message="enter a valid CIN ,check your national letter .")
private String cin;


//@NotNull(message = "phone cannot be null.")
//@NotBlank(message = "phone cannot be null.")
//@Size(min=9, max=30,message = "Phone must contains at least 9 characters.")
private String phone;

//@NotNull(message = "Birth day cannot be null.") 
//@NotBlank(message = "birth day cannot be null.")

private String dateNaissance;

//@NotNull(message = "joining date cannot be null.") 
//@NotBlank(message = "joining date cannot be null.")
private Date joiningDate;

	


private Long idagencee;
	
	public Long getIdagencee() {
	return idagencee;
}


@Override
	public String toString() {
		return "banquier [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adresse=" + adresse
				+ ", cin=" + cin + ", phone=" + phone + ", dateNaissance=" + dateNaissance + ", joiningDate="
				+ joiningDate + ", idagencee=" + idagencee + ", email=" + email + ", password=" + password + "]";
	}


public void setIdagencee(Long idagencee) {
	this.idagencee = idagencee;
}


	//@Column(name="email")
   // @NotNull(message = "email cannot be null.")
	//@Email(message = "Enter a valid email address.") 
	private String email;
 
//	@Column(name="password")
	private String password;

	

	public banquier() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
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




	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	 
	

	
	
	
	
}











