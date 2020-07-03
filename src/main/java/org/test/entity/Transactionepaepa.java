package org.test.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transactionepaepa {
	

	private long id_transaction;
	

	
	private String type;

	private String person;
	
	public String getPerson() {
		return person;
	}



	public void setPerson(String person) {
		this.person = person;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	private float somme;
	
	private Date date;
	
	private long  transactionStatus;
	

	
    public Transactionepaepa() {
    	
    }



	public long getId_transaction() {
		return id_transaction;
	}



	public void setId_transaction(long id_transaction) {
		this.id_transaction = id_transaction;
	}




	public float getSomme() {
		return somme;
	}



	public void setSomme(float somme) {
		this.somme = somme;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public long getTransactionStatus() {
		return transactionStatus;
	}



	public void setTransactionStatus(long transactionStatus) {
		this.transactionStatus = transactionStatus;
	}



	
	
	
	
	
}
