package com.beanes;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ChangeTracking;

@Entity
public class Client implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clt_client_id;
	
	private String clt_nom;
	private String clt_prenom;
	
	@Column (columnDefinition = "VARCHAR(60) CHECK (clt_profile IN ('Admin', 'Operateur', 'Visiteur'))")
	private String clt_profile;
	
	@Column (unique=true)
	private String clt_email;
	private String clt_mot_de_passe;
	
	@Column (columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private java.sql.Timestamp clt_dt_creation;
	
	@Column (columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private java.sql.Timestamp clt_dt_modification;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public int getClt_client_id() {
		return clt_client_id;
	}

	public void setClt_client_id(int clt_client_id) {
		this.clt_client_id = clt_client_id;
	}

	public String getClt_nom() {
		return clt_nom;
	}

	public void setClt_nom(String clt_nom) {
		this.clt_nom = clt_nom;
	}

	public String getClt_prenom() {
		return clt_prenom;
	}

	public void setClt_prenom(String clt_prenom) {
		this.clt_prenom = clt_prenom;
	}

	public String getClt_profile() {
		return clt_profile;
	}

	public void setClt_profile(String clt_profile) {
		this.clt_profile = clt_profile;
	}

	public String getClt_email() {
		return clt_email;
	}

	public void setClt_email(String clt_email) {
		this.clt_email = clt_email;
	}

	public String getClt_mot_de_passe() {
		return clt_mot_de_passe;
	}

	public void setClt_mot_de_passe(String clt_mot_de_passe) {
		this.clt_mot_de_passe = clt_mot_de_passe;
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

	@Override
	public String toString() {
		return "Client [clt_client_id=" + clt_client_id + ", clt_nom=" + clt_nom + ", clt_prenom=" + clt_prenom
				+ ", clt_profile=" + clt_profile + ", clt_email=" + clt_email + ", clt_mot_de_passe=" + clt_mot_de_passe
				+ ", clt_dt_creation=" + clt_dt_creation + ", clt_dt_modification=" + clt_dt_modification + "]";
	}

	
}
