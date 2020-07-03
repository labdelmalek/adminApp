package org.test.entity;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonBackReference;

public class credit implements Serializable {
	private static final long serialVersionUID = 1L;


    private long id;
	 private int nbmois;
	 private int somme; 
	 private float taux;
	 private float mensualite;
	 private boolean statut;
	 private int moisrest;
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public int getMoisrest() {
		return moisrest;
	}
	public void setMoisrest(int moisrest) {
		this.moisrest = moisrest;
	}
	
	public int getNbmois() {
		return nbmois;
	}
	public void setNbmois(int nbmois) {
		this.nbmois = nbmois;
	}
	public int getSomme() {
		return somme;
	}
	public void setSomme(int somme) {
		this.somme = somme;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}
	public float getMensualite() {
		return mensualite;
	}
	
	public void setMensualite(float mensualite) {
		this.mensualite = mensualite;
	}
	
}
