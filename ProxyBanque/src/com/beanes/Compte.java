package com.beanes;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Compte implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cpt_compte_id ;
	
	private String cpt_compte;
	private float cpt_solde;
	
	@JoinColumn (name = "cpt_client_id")
	@ManyToOne
	private Client cpt_client;
	
	@Column (columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private java.sql.Timestamp clt_dt_creation;
	
	@Column (columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private java.sql.Timestamp clt_dt_modification;
	private String cpt_statut;
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public int getCpt_compte_id() {
		return cpt_compte_id;
	}

	public void setCpt_compte_id(int cpt_compte_id) {
		this.cpt_compte_id = cpt_compte_id;
	}

	public String getCpt_compte() {
		return cpt_compte;
	}

	public void setCpt_compte(String cpt_compte) {
		this.cpt_compte = cpt_compte;
	}

	public float getCpt_solde() {
		return cpt_solde;
	}

	public void setCpt_solde(float cpt_solde) {
		this.cpt_solde = cpt_solde;
	}

	public Client getCpt_client() {
		return cpt_client;
	}

	public void setCpt_client(Client cpt_client) {
		this.cpt_client = cpt_client;
	}

	public java.sql.Timestamp getClt_dt_creation() {
		return clt_dt_creation;
	}

	public void setClt_dt_creation(java.sql.Timestamp clt_dt_creation) {
		this.clt_dt_creation = clt_dt_creation;
	}

	public java.sql.Timestamp getClt_dt_modification() {
		return clt_dt_modification;
	}

	public void setClt_dt_modification(java.sql.Timestamp clt_dt_modification) {
		this.clt_dt_modification = clt_dt_modification;
	}

	public String getCpt_statut() {
		return cpt_statut;
	}

	public void setCpt_statut(String cpt_statut) {
		this.cpt_statut = cpt_statut;
	}

	
	
}
