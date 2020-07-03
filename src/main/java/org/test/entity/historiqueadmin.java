package org.test.entity;

import java.util.Date;

public class historiqueadmin {


    private Long id;
	
	private Date jour;
	
	private double soldeagence;
	
	private double soldeclients;
	private double restecredit;
	private long idagence;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getJour() {
		return jour;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	public double getSoldeagence() {
		return soldeagence;
	}
	public void setSoldeagence(double soldeagence) {
		this.soldeagence = soldeagence;
	}
	public double getSoldeclients() {
		return soldeclients;
	}
	public void setSoldeclients(double soldeclients) {
		this.soldeclients = soldeclients;
	}
	public double getRestecredit() {
		return restecredit;
	}
	public void setRestecredit(double restecredit) {
		this.restecredit = restecredit;
	}
	public long getIdagence() {
		return idagence;
	}
	public void setIdagence(long idagence) {
		this.idagence = idagence;
	}
	public historiqueadmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
