package org.test.entity;

import java.util.Date;

public class infocredit {
private static final long serialVersionUID = 1L;

    private Long id;
	
	private String nom;

	private String prenom;

	private String cin;
private float salaire;
	public float getSalaire() {
	return salaire;
}
public void setSalaire(float salaire) {
	this.salaire = salaire;
}
	private  String typeemployee ;
private  float sommeclient ;
private  String typecredit ;
private  float montantcredit ;
private  int nombremois ;
private  float mensualite ;

private  Date datedemande ;

private  Long idagence ;

private  Long idcredit ;
public Long getIdcredit() {
	return idcredit;
}
public void setIdcredit(Long idcredit) {
	this.idcredit = idcredit;
}
public Long getIdagence() {
	return idagence;
}
public void setIdagence(Long idagence) {
	this.idagence = idagence;
}
public float getMensualite() {
	return mensualite;
}
public void setMensualite(float mensualite) {
	this.mensualite = mensualite;
}
public Date getDatedemande() {
	return datedemande;
}
public void setDatedemande(Date datedemande) {
	this.datedemande = datedemande;
}
public infocredit() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getTypeemployee() {
	return typeemployee;
}
public void setTypeemployee(String typeemployee) {
	this.typeemployee = typeemployee;
}
public float getSommeclient() {
	return sommeclient;
}
public void setSommeclient(float sommeclient) {
	this.sommeclient = sommeclient;
}
public String getTypecredit() {
	return typecredit;
}
public void setTypecredit(String typecredit) {
	this.typecredit = typecredit;
}
public float getMontantcredit() {
	return montantcredit;
}
public void setMontantcredit(float montantcredit) {
	this.montantcredit = montantcredit;
}
public int getNombremois() {
	return nombremois;
}
public void setNombremois(int nombremois) {
	this.nombremois = nombremois;
}




	
}
